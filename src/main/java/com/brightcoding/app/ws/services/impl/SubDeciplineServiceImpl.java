package com.brightcoding.app.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightcoding.app.ws.entities.SubDecipline;
import com.brightcoding.app.ws.repositories.SubDeciplineRepository;
import com.brightcoding.app.ws.services.SubDeciplineService;
import com.brightcoding.app.ws.shared.dto.SubDeciplineDto;
@Service
public class SubDeciplineServiceImpl implements SubDeciplineService {
	@Autowired
	SubDeciplineRepository subDeciplineRepository;

	@Override
	public List<SubDeciplineDto> getAllSubdecipline() {
		
		
		ModelMapper modelMapper = new ModelMapper();
		List<SubDecipline> list = (List<SubDecipline>) subDeciplineRepository.findAll();
		List<SubDeciplineDto> listDto=new ArrayList<>();
		for (SubDecipline subDecipline : list) {
			SubDeciplineDto SubDto = modelMapper.map(subDecipline, SubDeciplineDto.class);
			listDto.add(SubDto);
		}
		return listDto;
	}

	@Override
	public SubDeciplineDto createSubDecipline(SubDeciplineDto subDeciplineDto) {
		ModelMapper modelMapper = new ModelMapper();
		SubDecipline subDecipline=modelMapper.map(subDeciplineDto, SubDecipline.class);
		subDeciplineRepository.save(subDecipline);
		return subDeciplineDto;
		
	}

	@Override
	public SubDeciplineDto getSubDeciplineById(long subDeciplineId) {
		SubDecipline subDecipline = subDeciplineRepository.findById(subDeciplineId).get();
		ModelMapper modelMapper = new ModelMapper();
		SubDeciplineDto subDeciplineDto=modelMapper.map(subDecipline, SubDeciplineDto.class);
		return subDeciplineDto;
	}

	@Override
	public SubDeciplineDto updateSubdecipline(Long Id, SubDeciplineDto subDeciplineDto) {
		
		SubDecipline subDecipline = subDeciplineRepository.findById(Id).get();
		if (subDecipline==null) {
			throw new RuntimeException("no subdecipline with this id ");
		}
		else {
			subDecipline = subDeciplineRepository.save(subDecipline);
		}
		
		
		return subDeciplineDto;
	}

	@Override
	public void deleteSubdecipline(long subDeciplineId) {
		SubDecipline subDecipline = subDeciplineRepository.findById(subDeciplineId).get();
		if (subDecipline == null) throw new RuntimeException("subdecipline not found");
		subDeciplineRepository.delete(subDecipline);
		
	}

	
}
