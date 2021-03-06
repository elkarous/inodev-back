package com.brightcoding.app.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brightcoding.app.ws.entities.CondidatEntity;
import com.brightcoding.app.ws.entities.EducationEntity;
import com.brightcoding.app.ws.entities.Hobbies;
import com.brightcoding.app.ws.entities.SkillsEntity;
import com.brightcoding.app.ws.repositories.CondidatRepository;
import com.brightcoding.app.ws.repositories.HobbiesRepository;
import com.brightcoding.app.ws.services.HobbiesService;
import com.brightcoding.app.ws.shared.dto.CondidatDto;
import com.brightcoding.app.ws.shared.dto.HobbiesDto;
import com.brightcoding.app.ws.shared.dto.SkillsDto;
@Service

public class HobbiesServiceImpl  implements  HobbiesService{
	@Autowired
	HobbiesRepository hobbiesRepository;

    @Autowired
    CondidatRepository condidatRepository;


	@Override
	public List<HobbiesDto> getAllHobbies() {
		ModelMapper modelMapper = new ModelMapper();
		List<Hobbies> list=(List<Hobbies>) hobbiesRepository.findAll();
		 List<HobbiesDto> listDto=new ArrayList<>();
        for(Hobbies  hobbie : list) {
        	HobbiesDto hobbieDto = modelMapper.map(hobbie, HobbiesDto.class);
        	listDto.add(hobbieDto);
        }
		
		return listDto;
	}

	@Override
	public HobbiesDto createHobbies(HobbiesDto hobbiesDto) {
		System.out.println(hobbiesDto.getDescription());
		ModelMapper modelMapper = new ModelMapper();
		
		Hobbies hobbie = modelMapper.map(hobbiesDto, Hobbies.class);
		System.out.println(hobbiesDto.getDescription());
	  hobbiesRepository.save(hobbie);
		
		
		
		return hobbiesDto;
	}

	@Override
	public HobbiesDto getHobbies(Long HobbiesId) {
		
        Hobbies hobbie = hobbiesRepository.findById(HobbiesId).get();
		ModelMapper modelMapper = new ModelMapper();
	    HobbiesDto hobbiesDto =modelMapper.map(hobbie, HobbiesDto.class);
	    
		return hobbiesDto;	
	}

	@Override
	public HobbiesDto updateHobbies(Long Id, HobbiesDto HobbiesDto) {
		
		Hobbies hobbies =hobbiesRepository.findById(Id).get();


        if(hobbies == null) {
        	throw new RuntimeException("no hobbies with this id ");
        	
        }
        else {
        
         hobbies = hobbiesRepository.save(hobbies);
        }
      
        return HobbiesDto;
	
	}

	@Override
	public void deleteHobbies(Long id,Long idCondidat) {
		Hobbies hobbie=hobbiesRepository.findById(id).get();
    	CondidatEntity condidat=condidatRepository.findById(idCondidat).get();
    	condidat.getEducation().remove(hobbie);
    	condidatRepository.save(condidat);
		
	}
	/*
	public void deleteHobbies(long HobbiesId) {
	
		Hobbies hobbie= hobbiesRepository.findById(HobbiesId).get();

        if(hobbie == null) throw new RuntimeException("hobbie not found");

        hobbiesRepository.delete(hobbie);

		*/
	}


