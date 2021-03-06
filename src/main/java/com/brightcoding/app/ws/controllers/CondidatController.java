package com.brightcoding.app.ws.controllers;
import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Files;
import com.brightcoding.app.ws.entities.CondidatEntity;
import com.brightcoding.app.ws.entities.CondidatOffreEntity;
import com.brightcoding.app.ws.entities.Role;
import com.brightcoding.app.ws.repositories.CondidatOffreRepository;
import com.brightcoding.app.ws.repositories.CondidatRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.brightcoding.app.ws.responses.CondidatResponse;
import com.brightcoding.app.ws.services.CondidatService;
import com.brightcoding.app.ws.services.NoteService;
import com.brightcoding.app.ws.shared.dto.CondidatDto;


import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
//http://localhost:8081/condidat
@RestController
@RequestMapping("/condidat")
public class CondidatController {
    @Autowired
    CondidatService condidatService;
    @Autowired
    CondidatRepository repository;
    @Autowired
    CondidatOffreRepository repo;
    @Autowired
    ServletContext context;
    @Autowired
    NoteService noteService;
    
    @GetMapping
    public Principal getUser(Principal user) {
        return user;
    }
  //http://localhost:8081/condidat
    @GetMapping(produces={ MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CondidatResponse>> getAllCondidats(@RequestParam(value="page", defaultValue = "1") int page, @RequestParam(value="limit", defaultValue = "20")  int limit , @RequestParam(value="search", defaultValue = "") String search, @RequestParam(value="status", defaultValue = "1") int status) {

        List<CondidatResponse> condidatsResponse = new ArrayList<>();

        List<CondidatDto> condidats = condidatService.getCondidat(page, limit, search, status);

        for(CondidatDto condidatDto: condidats) {

            ModelMapper modelMapper = new ModelMapper();
            CondidatResponse condidatResponse =  modelMapper.map(condidatDto, CondidatResponse.class);

            condidatsResponse.add(condidatResponse);
        }
        return new ResponseEntity<List<CondidatResponse>>(condidatsResponse, HttpStatus.OK);
    }
  //http://localhost:8081/condidat/add

     @PostMapping("/add")
    public CondidatDto createCondidat(  @RequestBody CondidatDto condidatDto) {
    	
         return condidatService.createCondidat(condidatDto);



    }
     
   //http://localhost:8081/condidat/getAll
     
     @GetMapping("/getAll")
     public List<CondidatDto> getAll(){
    	 return condidatService.getAll();
     }
   //http://localhost:8081/condidat/suprvisor
     
    @PostMapping("/suprvisor")

    public CondidatDto createSupervisor(  @RequestBody CondidatDto condidatDto) {
   	 condidatDto.setRole(Role.Superviser);
     return condidatService.createCondidat(condidatDto);


    }
    
    //http://localhost:8081/condidat/company
    
    @PostMapping("/company" )

    public  CondidatDto  createsociete(@RequestBody CondidatDto condidatDto) {
    	 condidatDto.setRole(Role.Superviser);
         return condidatService.createCondidat(condidatDto);

    }
    //http://localhost:8081/condidat/put
    @PutMapping("/put" )

    public CondidatEntity  modifiercondidat(@RequestBody CondidatEntity condidatDto) {
    	 
         return repository.save( condidatDto);

    }
    //http://localhost:8081/condidat/userId
    
    @GetMapping(path="/{userId}", produces={ MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CondidatResponse> getCondidat(@PathVariable String userId) {

        CondidatDto condidatDto = condidatService.getCondidatByUserId(userId);

        CondidatResponse condidatResponse = new CondidatResponse();

        BeanUtils.copyProperties(condidatDto, condidatResponse);

        return new ResponseEntity<CondidatResponse>(condidatResponse, HttpStatus.OK);
    }

    //http://localhost:8081/condidat/{id}



    @PutMapping(
            path="/{id}"
    )
    public ResponseEntity<CondidatResponse> updateCondidat(
            @PathVariable String id , @RequestPart(value = "condidat") String condidatRequest,
            @RequestPart(value = "photo", required = false) MultipartFile file) throws JsonProcessingException {

        CondidatEntity off = new ObjectMapper().readValue(condidatRequest, CondidatEntity.class);
        off.setPhoto(file.getOriginalFilename());
        CondidatDto updateCondidat = condidatService.updateCondidat(id, off);
        boolean isExit = new File(context.getRealPath("src/web/Images/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("src/web/Images/")).mkdir();
            System.out.println("mk dir.............");
        }
        if (file.getName() != null) {
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("src/web/Images/"+File.separator+newFileName+off.getUserId()));
        String distfile = "C:/Users/ASUS/Documents/GitHub/inodev-back/src/web/Images"+ file.getOriginalFilename();
            updateCondidat.setPhoto(file.getOriginalFilename()  );

            try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
            Files.copy(file.getInputStream(),
                    Paths.get(distfile),
                    StandardCopyOption.REPLACE_EXISTING);

        }catch(Exception e) {
            e.printStackTrace();
        }
        }
        CondidatResponse condidatResponse = new CondidatResponse();
        BeanUtils.copyProperties(updateCondidat, condidatResponse);

        return new ResponseEntity<CondidatResponse>(condidatResponse, HttpStatus.ACCEPTED);
    }
    //http://localhost:8081/condidat//img/{id}
    @GetMapping(path="/img/{id}")
    public byte[] getPhoto(@PathVariable String id) throws Exception{
        CondidatDto condidatDto = condidatService.getCondidatByUserId(id);
        return Files.readAllBytes(Paths.get("C:/Users/ASUS/Documents/GitHub/inodev-back/src/web/Images/"+condidatDto.getPhoto()));

    }
    //http://localhost:8081/condidat/{id}
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable String id) {

        condidatService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //http://localhost:8081/condidat/note/{id}/{offerId}
    
    @GetMapping("/note/{id}/{offerId}")
    public CondidatOffreEntity getNoteCondidat(@PathVariable("id") long id,@PathVariable("offerId") int offerId) {
    	
    	return noteService.noteFinal(id, offerId) ;
    	
    }
    //http://localhost:8081/condidat/note/{id}/{noteInterview}
    @PutMapping("/note/{id}/{noteInterview}")
    public CondidatOffreEntity notefinal(@PathVariable("id") long id,@PathVariable("noteInterview") float noteInterview) {
    	
    	return noteService.noteTerminale(id, noteInterview) ;
    	
    }
    
    
    @PutMapping(
            path="/update/{id}"
    )
    public void update(@PathVariable("id") String userId , @RequestBody CondidatEntity condidatDto) {
    	
    	condidatService.updateCondidat(userId, condidatDto);
    	
    }
    
    
    @GetMapping("/application/{id}")
    public List<CondidatOffreEntity> getApplication(@PathVariable("id") long id) {
    	
    	
    	return repo.getApplication(id);
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
