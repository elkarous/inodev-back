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

import com.brightcoding.app.ws.shared.dto.ProjectDto;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.brightcoding.app.ws.entities.OfferEntity;
import com.brightcoding.app.ws.entities.Project;
import com.brightcoding.app.ws.entities.SubDecipline;
import com.brightcoding.app.ws.repositories.ProjectRepository;
import com.brightcoding.app.ws.services.ProjectService;

@RestController
@RequestMapping("/Project")

public class ProjectController {
	 @Autowired
	    ProjectService projectService;
	    @Autowired
	    ProjectRepository repository;
	    @Autowired
		ServletContext context;
		
	    
	  //http://localhost:8081/Project
	    @GetMapping
		public List<ProjectDto> getAll(){
			return projectService.getAllProject();
		}
	    //http://localhost:8081/Project
		@PostMapping

		public String createSubDecipline(@RequestParam("image") MultipartFile file,
	            @RequestParam("project") String subdecipline) throws JsonParseException, JsonMappingException, Exception {
			
			
			Project subDecipline = new ObjectMapper().readValue(subdecipline, Project.class);

			String filename = file.getOriginalFilename();

			String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);

			File serverFile = new File (context.getRealPath("/src/web/spe/"+File.separator+newFileName));
			
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


			subDecipline.setImage(newFileName);
			repository.save(subDecipline);


			return ("ajout d'unespecialité avec succssée");

			}
				
	    //http://localhost:8081/Project/{id}
	    @GetMapping("/{id}")
		public ProjectDto getProjectById(@PathVariable("id") long id) {
			return projectService.getProject(id);
		}
	  //http://localhost:8081/Project/{id}
	    @DeleteMapping("/{id}")
		public void deleteProject(@PathVariable("id")long id) {
			 projectService.deleteProject(id);
		}
	  //http://localhost:8081/Project/{id}
	    @PutMapping()
		public Project updateProject( @RequestBody Project ProjectDto) {
			return repository.save(ProjectDto);
		}
	    @GetMapping(path="/Imgarticles/{id}")
	    public byte[] getPhoto(@PathVariable("id") long id) throws Exception{
	        Project subdecipline= repository.findById(id).get();
	        return Files.readAllBytes(Paths.get("C:/Users/ASUS/Documents/GitHub/inodev-back/src/web/spe/"+subdecipline.getImage()));
	    }
	    
}
