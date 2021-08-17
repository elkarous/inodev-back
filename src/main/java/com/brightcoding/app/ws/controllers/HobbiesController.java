package com.brightcoding.app.ws.controllers;

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

import com.brightcoding.app.ws.entities.Hobbies;
import com.brightcoding.app.ws.services.HobbiesService;
import com.brightcoding.app.ws.shared.dto.HobbiesDto;

@RestController
@RequestMapping("/hobbies")
public class HobbiesController {
	
	
	@Autowired
	HobbiesService hobbiesService;
	
    //http://localhost:8081/hobbies
	@GetMapping
	public List<HobbiesDto> getAll(){
		return hobbiesService.getAllHobbies();
	}
	   //http://localhost:8081/hobbies
	// create new hobbie
	@PostMapping
	public HobbiesDto createHobbies(  @RequestBody HobbiesDto hobbiesDto) {
		return hobbiesService.createHobbies(hobbiesDto);
		
	}
	
	   //http://localhost:8081/hobbies/{id}
	//get hobbies by id 
	@GetMapping("/{id}")
	public HobbiesDto getHobbiesById( @PathVariable ("id") long id) {
		return hobbiesService.getHobbies(id);
	}
	//http://localhost:8081/hobbies/{id}
	//delete hobbies by id 
	@DeleteMapping("/{id}")
	public void deleteHobbies(long id) {
		 hobbiesService.deleteHobbies(id);
	}
	//http://localhost:8081/hobbies/{id}
	//update one hobbies
	@PutMapping("/{id}")
	public HobbiesDto updateHobbies( @PathVariable ("id") long Id, @RequestBody HobbiesDto HobbiesDto) {
		return hobbiesService.updateHobbies(Id, HobbiesDto);
	}
	
	
	

}
