package com.brightcoding.app.ws.services.impl;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightcoding.app.ws.repositories.ProjectRepository;

import com.brightcoding.app.ws.entities.Project;

import com.brightcoding.app.ws.repositories.CondidatRepository;
import com.brightcoding.app.ws.repositories.OfferRepository;
import com.brightcoding.app.ws.services.ProjectService;
import com.brightcoding.app.ws.shared.Utils;


import com.brightcoding.app.ws.shared.dto.ProjectDto;
@Service
public class ProjectServiceImp implements ProjectService  { 
	@Autowired
	OfferRepository offerRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	CondidatRepository userRepository;
	
	@Autowired
	Utils util;
	@Override
	 public List<ProjectDto> getAllProject () {


		ModelMapper modelMapper = new ModelMapper();
		List<Project> list=(List<Project>) projectRepository.findAll();
		 List<ProjectDto> listDto=new ArrayList<>();
        for(Project  hobbie : list) {
        	ProjectDto hobbieDto = modelMapper.map(hobbie, ProjectDto.class);
        	listDto.add(hobbieDto);
        }
		
		return listDto;
	}
	

	@Override
	public ProjectDto createProject(ProjectDto project) {
		 

	        ModelMapper modelMapper = new ModelMapper();
	        Project Project = modelMapper.map(project, Project.class);
	         projectRepository.save(Project);

	      

	        return project;
	
		
	}

	@Override
	public ProjectDto getProject(Long projectId) {

        Project project = projectRepository.findById(projectId).get();
		ModelMapper modelMapper = new ModelMapper();
	    ProjectDto projectDto =modelMapper.map(project, ProjectDto.class);
	    
		return projectDto;
		
	}

	@Override
	public ProjectDto updateproject(Long Id, ProjectDto projectDto) {
		


        if(projectRepository.findById(Id) == null) {
        	throw new RuntimeException("no project with this id ");
        }
        else {
        	 ModelMapper modelMapper = new ModelMapper();
        	 Project project = modelMapper.map(projectDto, Project.class);

        	 projectRepository.save(project);
        	
        }
        	
		return projectDto;
	}

	@Override
	public void deleteProject(Long ProjectId) {

 projectRepository.deleteById(ProjectId);

		
	}








	


	

}
