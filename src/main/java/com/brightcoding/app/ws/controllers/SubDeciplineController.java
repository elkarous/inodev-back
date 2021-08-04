package com.brightcoding.app.ws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brightcoding.app.ws.services.SubDeciplineService;
import com.brightcoding.app.ws.shared.dto.HobbiesDto;
import com.brightcoding.app.ws.shared.dto.SubDeciplineDto;

@RestController
@RequestMapping("/subDecipline")

public class SubDeciplineController {
	@Autowired
	SubDeciplineService subDeciplineService;
	
	//get all subDecipline
	@GetMapping
	public List<SubDeciplineDto> getAll(){
		return subDeciplineService.getAllSubdecipline();
		
	}
	
	// create new subdecipline
	@PostMapping
	public SubDeciplineDto createSubDecipline(SubDeciplineDto subDto) {
		return subDeciplineService.createSubDecipline(subDto);
	}
	
	// get subdecipline by id 
	@GetMapping("/{id}")
	public SubDeciplineDto getSubDeciplineById(long id) {
		return subDeciplineService.getSubDeciplineById(id);
	}
	
	//delete subdecipline
	@DeleteMapping("/{id}")
	public void deletesubdecipline(long id) {
		subDeciplineService.deleteSubdecipline(id);
	}
	
	//update one subDecipline
	@PutMapping("/{id}")
	public SubDeciplineDto updateHobbies(Long Id, SubDeciplineDto subDto) {
		return subDeciplineService.updateSubdecipline(Id, subDto);
	}
	
	

}
