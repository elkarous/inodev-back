package com.brightcoding.app.ws.controllers;


import com.brightcoding.app.ws.entities.SpecialiteEntity;
import com.brightcoding.app.ws.repositories.CondidatRepository;

import com.brightcoding.app.ws.repositories.SpecialiteRepository;

import com.brightcoding.app.ws.shared.Utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@RestController
@RequestMapping("/specialite")
public class SpecialiteController {
    @Autowired
    SpecialiteRepository repository;
    @Autowired
    CondidatRepository condidatRepository;
   
    @Autowired
    ServletContext context;
    @Autowired
    Utils util;
  //http://localhost:8081/specialite
    @GetMapping
    public List<SpecialiteEntity> getAllspef() {
    
    	List<SpecialiteEntity> offres = repository.findAll();

        return offres;
    }
    //http://localhost:8081/specialite/a/{name}
    @GetMapping("/a/{name}")
    public List<SpecialiteEntity> getNom(@PathVariable(value = "name")String name)
    {
        List offre = new ArrayList<>();
        repository.findByName(name) .forEach(offre::add);

        return offre;
    }
 
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")int id ) {
    	repository.deleteById(id);
    }
    
  //http://localhost:8081/specialite/getAll
    @GetMapping ("/getAll")
    public ResponseEntity<List<String>> getAll()
    {
        List<String> listof = new ArrayList<String>();
        String filesPath = context.getRealPath("src/web/images/spe/");
        File filefolder = new File(filesPath);
        if (filefolder != null)
        {
            for (File file :filefolder.listFiles())
            {
                if(!file.isDirectory())
                {
                    String encodeBase64 = null;
                    try {
                        String extension = FilenameUtils.getExtension(file.getName());
                        FileInputStream fileInputStream = new FileInputStream(file);
                        byte[] bytes = new byte[(int)file.length()];
                        fileInputStream.read(bytes);
                        encodeBase64 = Base64.getEncoder().encodeToString(bytes);
                        listof.add("data:image/"+extension+";base64,"+encodeBase64);
                        fileInputStream.close();


                    }catch (Exception e){

                    }
                }
            }
        }
        return new ResponseEntity<List<String>>(listof, HttpStatus.OK);
    }
  //http://localhost:8081/specialite/
    @PostMapping
    public String createspe (@RequestParam("image") MultipartFile file,
                               @RequestParam("spe") String specialite) throws JsonParseException, JsonMappingException, Exception
    {
      
        
        SpecialiteEntity specialiteEntity = new ObjectMapper().readValue(specialite, SpecialiteEntity.class);

        String filename = file.getOriginalFilename();
       
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
       
        File serverFile = new File (context.getRealPath("/src/web/spe/"+File.separator+newFileName));
        System.out.println("erreur ok ");
        String distfile = "C:/Users/ASUS/Documents/GitHub/inodev-back/src/web/spe/"+ file.getOriginalFilename();
        try
        {
           
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
            Files.copy(file.getInputStream(),
                    Paths.get(distfile),
                    StandardCopyOption.REPLACE_EXISTING);

         

          


        }catch(Exception e) {
            e.printStackTrace();
        }

       
        specialiteEntity.setImage(newFileName);
        repository.save(specialiteEntity);
        
        
        return ("ajout d'unespecialité avec succssée");

    }
  //http://localhost:8081/specialite/{id}
    @GetMapping("/{id}")
    public ResponseEntity<SpecialiteEntity> getOffreById(@PathVariable(value = "id") int Id)
    {
        SpecialiteEntity offre = repository.findById(Id).get();
        return ResponseEntity.ok().body(offre);
    }
  //http://localhost:8081/specialite/Imgarticles/{id}
    @GetMapping(path="/Imgarticles/{id}")
    public byte[] getPhoto(@PathVariable("id") int id) throws Exception{
        SpecialiteEntity offre = repository.findById(id).get();
        return Files.readAllBytes(Paths.get("C:/Users/ASUS/Documents/GitHub/inodev-back/src/web/spe/"+offre.getImage()));
    }

   
  //http://localhost:8081/specialite/edit/{id}
    @PutMapping("/edit")
    public String update( @RequestBody SpecialiteEntity specialite) {
 
        repository.save(specialite);
            return ("ok");

    }

}
