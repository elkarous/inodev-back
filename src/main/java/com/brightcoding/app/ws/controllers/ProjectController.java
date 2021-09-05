package com.brightcoding.app.ws.controllers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.brightcoding.app.ws.shared.dto.ProjectDto;
import com.brightcoding.app.ws.entities.OfferEntity;
import com.brightcoding.app.ws.entities.Project;
import com.brightcoding.app.ws.repositories.ProjectRepository;
import com.brightcoding.app.ws.services.ProjectService;

@RestController
@RequestMapping("/Project")

public class ProjectController {
	 @Autowired
	    ProjectService projectService;
	    @Autowired
	    ProjectRepository repository;
	    
	    
	  //http://localhost:8081/Project
	    @GetMapping
		public List<ProjectDto> getAll(){
			return projectService.getAllProject();
		}
	    //http://localhost:8081/Project
	    @PostMapping
		public ProjectDto createProject(@RequestBody  ProjectDto projectDto) {
			return projectService.createProject(projectDto);
			
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
	    @PutMapping("/{id}")
		public ProjectDto updateProject( @PathVariable ("id" ) Long id, @RequestBody ProjectDto ProjectDto) {
			return projectService.updateproject(id, ProjectDto);
		}
	    @GetMapping(path="/Imgarticles/{id}")
	    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
	        Project offer= repository.findById(id).get();
	        return Files.readAllBytes(Paths.get("C:/Users/ASUS/Documents/GitHub/inodev-back/src/web/spe/"+offer.getNom()));
	    }
	    
}
