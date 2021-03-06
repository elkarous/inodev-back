package com.brightcoding.app.ws.services.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightcoding.app.ws.entities.AddressEntity;
import com.brightcoding.app.ws.entities.CondidatEntity;
import com.brightcoding.app.ws.entities.Role;

import com.brightcoding.app.ws.repositories.AddressRepository;
import com.brightcoding.app.ws.repositories.CondidatRepository;

import com.brightcoding.app.ws.services.AddressService;
import com.brightcoding.app.ws.shared.Utils;
import com.brightcoding.app.ws.shared.dto.AddressDto;
import com.brightcoding.app.ws.shared.dto.ResourceDto;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	CondidatRepository userRepository;
	
	@Autowired
	Utils util;
	
	@Override
	public List<AddressDto> getAllAddresses(String email) {
		
		CondidatEntity currentUser = userRepository.findByEmail(email).get();
		
		List<AddressEntity> addresses = currentUser.getRole() == Role.Admin? (List<AddressEntity>) addressRepository.findAll() : addressRepository.findByUser(currentUser);
		
		Type listType = new TypeToken<List<AddressDto>>() {}.getType();
		List<AddressDto> addressesDto = new ModelMapper().map(addresses, listType);
		
		return addressesDto;
	}
	
	
	@Override
	public AddressDto createAddress(AddressDto address, String email) {
		
		CondidatEntity currentUser = userRepository.findByEmail(email).get();
		
		ModelMapper modelMapper = new ModelMapper();
		ResourceDto resourceDto = modelMapper.map(currentUser, ResourceDto.class);
		
		address.setAddressId(util.generateStringId(30));
		address.setUser(resourceDto);
		
		AddressEntity addressEntity = modelMapper.map(address, AddressEntity.class); 
		
		AddressEntity newAddress = addressRepository.save(addressEntity);
		
		AddressDto addressDto = modelMapper.map(newAddress, AddressDto.class);
		
		return addressDto;
	}
	
	
	@Override
	public AddressDto getAddress(String addressId) {
		
		AddressEntity addressEntity = addressRepository.findByAddressId(addressId);
		
		ModelMapper modelMapper = new ModelMapper();
		
		AddressDto addressDto = modelMapper.map(addressEntity, AddressDto.class);
		
		return addressDto;
	}

	@Override
	public void deleteAddress(String addressId) {
		
		AddressEntity address = addressRepository.findByAddressId(addressId);
		
		if(address == null) throw new RuntimeException("Address not found");
		
		addressRepository.delete(address);
	
	}


}
