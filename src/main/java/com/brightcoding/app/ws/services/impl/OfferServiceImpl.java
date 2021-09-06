package com.brightcoding.app.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightcoding.app.ws.entities.OfferEntity;
import com.brightcoding.app.ws.entities.Project;
import com.brightcoding.app.ws.entities.SpecialiteEntity;
import com.brightcoding.app.ws.entities.SubDecipline;
import com.brightcoding.app.ws.repositories.OfferRepository;
import com.brightcoding.app.ws.repositories.SpecialiteRepository;
import com.brightcoding.app.ws.repositories.SubDeciplineRepository;
import com.brightcoding.app.ws.services.OfferService;
import com.brightcoding.app.ws.shared.dto.CondidatDto;
import com.brightcoding.app.ws.shared.dto.OfferDto;
@Service
public class OfferServiceImpl implements  OfferService{
	@Autowired
	OfferRepository offerRepository;
	@Autowired
	SpecialiteRepository specialiteRepository;
	
	
	@Autowired
	SubDeciplineRepository subDeciplineRepository;
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
	// find offer by specialite
	@Override
	public List<OfferEntity> findOffrebySpe(String nom) {
		
		List<OfferEntity> listOffer=new ArrayList<>();
		SpecialiteEntity specialite = specialiteRepository.findByNom(nom); 
		for( SubDecipline subDecipline:specialite.getSubDecipline()) {
			for(Project project:subDecipline.getProject()) {
			listOffer.addAll(project.getOffers());
			
		}
		}
		
		return listOffer;
		
	}
	// find offer by niveau
	@Override
	public List<OfferEntity> getOffreByNiveau(String niveau) {
		
		List<OfferEntity> offer = offerRepository.findByNiveau(niveau);
		
	    
		return offer;	
		
	}
	// find offer by duree 
	@Override
public List<OfferEntity> getOffreByDuree(String duree) {
		
		List<OfferEntity> offer = offerRepository.findByDuree(duree);
		
		return offer;	
		
	}
	// find offer by supervisor
	@Override
	public List<OfferEntity> getOffreBySupervisor(String supervisor) {
		
		List<OfferEntity> offer = offerRepository.findBySupervisor(supervisor);
		
	    
		return offer;	
		
	}
	


	@Override
	public List<OfferEntity> findBysearch(String nom, String duree, String niveau) {
		// TODO Auto-generated method stub
		return null;
	}

}
