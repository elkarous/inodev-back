package com.brightcoding.app.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightcoding.app.ws.entities.OfferEntity;
import com.brightcoding.app.ws.repositories.OfferRepository;
import com.brightcoding.app.ws.services.OfferService;
import com.brightcoding.app.ws.shared.dto.OfferDto;
@Service
public class OfferServiceImpl implements  OfferService{
	@Autowired
	OfferRepository offerRepository;
	@Override
	public List<OfferDto> getAllOffre() {
		ModelMapper modelMapper = new ModelMapper();
		List<OfferEntity> list=(List<OfferEntity>) offerRepository.findAll();
		 List<OfferDto> listDto=new ArrayList<>();
        for(OfferEntity  offer : list) {
        	OfferDto offerDto = modelMapper.map(offer, OfferDto.class);
        	listDto.add(offerDto);
        }
		
		return listDto;
	}
	@Override
	public OfferDto createOffre(OfferDto offerDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		OfferEntity offer = modelMapper.map(offerDto, OfferEntity.class);
		
	  offerRepository.save(offer);
		
		
		
		return offerDto;
	}
	@Override
	public OfferDto getOffre(int offerId) {
		
        OfferEntity offer = offerRepository.findById(offerId).get();
		ModelMapper modelMapper = new ModelMapper();
	    OfferDto offerDto =modelMapper.map(offer, OfferDto.class);
	    
		return offerDto;	
	}
	@Override
	public OfferDto updateOffre(int Id, OfferDto offerDto) {
		
		


        if(offerRepository.findById(Id) == null) {
        	throw new RuntimeException("no offer with this id ");
        	
        }
        else {
        	ModelMapper modelMapper = new ModelMapper();
    		
    		OfferEntity offer = modelMapper.map(offerDto, OfferEntity.class);
         offer = offerRepository.save(offer);
        }
      
        return offerDto;
	
	}
	@Override
	public void deleteOffre(int offerId) {
	
		offerRepository.deleteById(offerId);

		
	}
}
