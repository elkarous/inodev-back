package com.brightcoding.app.ws.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.brightcoding.app.ws.entities.OfferEntity;
import com.brightcoding.app.ws.entities.SpecialiteEntity;
import com.brightcoding.app.ws.entities.SubDecipline;
import com.brightcoding.app.ws.repositories.SubDeciplineRepository;
import com.brightcoding.app.ws.services.SubDeciplineService;
import com.brightcoding.app.ws.shared.dto.HobbiesDto;
import com.brightcoding.app.ws.shared.dto.SubDeciplineDto;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/subDecipline")

public class SubDeciplineController {
	@Autowired
	SubDeciplineService subDeciplineService;
	
	@Autowired
	SubDeciplineRepository subdeciplineRepo;
	@Autowired
	ServletContext context;
	
	
	
	//get all subDecipline
	@GetMapping
	public List<SubDeciplineDto> getAll(){
		return subDeciplineService.getAllSubdecipline();
		
	}
	
	// create new subdecipline
	@PostMapping
	public String createSubDecipline(@RequestParam("image") MultipartFile file,
            @RequestParam("subdecipline") String subdecipline) throws JsonParseException, JsonMappingException, Exception {
		
		
		SubDecipline subDecipline = new ObjectMapper().readValue(subdecipline, SubDecipline.class);

		String filename = file.getOriginalFilename();

		String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);

		File serverFile = new File (context.getRealPath("/src/web/spe/"+File.separator+newFileName));
		System.out.println("erreur ok ");
		String distfile = "D:/inodev/inodev-back/src/web/spe/"+ file.getOriginalFilename();
		try
		{

		FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
		Files.copy(file.getInputStream(),
		     Paths.get(distfile),
		     StandardCopyOption.REPLACE_EXISTING);


		}catch(Exception e) {
		e.printStackTrace();
		}


		subDecipline.setImage(newFileName);
		subdeciplineRepo.save(subDecipline);


		return ("ajout d'unespecialité avec succssée");

		}
				
			
		
		
	 @GetMapping(path="/Imgarticles/{id}")
	    public byte[] getPhoto(@PathVariable("id") long id) throws Exception{
	        SubDecipline subdecipline= subdeciplineRepo.findById(id).get();
	        return Files.readAllBytes(Paths.get("D:/inodev/inodev-back/src/web/spe/"+subdecipline.getImage()));
	    }
		
	
	// get subdecipline by id 
	@GetMapping("/{id}")
	public SubDeciplineDto getSubDeciplineById( @PathVariable("id") long id) {
		return subDeciplineService.getSubDeciplineById(id);
	}
	
	//delete subdecipline
	@DeleteMapping("/{id}")
	public void deletesubdecipline( @PathVariable("id") long id) {
		subDeciplineService.deleteSubdecipline(id);
	}
	
	//update one subDecipline
	@PutMapping("/{id}")
	public SubDeciplineDto updateHobbies( @PathVariable("id") Long Id, @RequestBody SubDeciplineDto subDto) {
		return subDeciplineService.updateSubdecipline(Id, subDto);
	}
	@GetMapping("/sub/{subDecpline}")
	public List<OfferEntity> findOffrebySub( @PathVariable("subDecpline") String nom) {
		return subDeciplineService.findOffrebySub(nom);
	}
	

}
