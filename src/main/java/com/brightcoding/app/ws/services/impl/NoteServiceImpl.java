package com.brightcoding.app.ws.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightcoding.app.ws.entities.AnneeEducationEntity;
import com.brightcoding.app.ws.entities.CondidatEntity;
import com.brightcoding.app.ws.entities.CondidatOffreEntity;
import com.brightcoding.app.ws.entities.EducationEntity;
import com.brightcoding.app.ws.entities.OfferEntity;
import com.brightcoding.app.ws.repositories.CondidatOffreRepository;
import com.brightcoding.app.ws.repositories.CondidatRepository;
import com.brightcoding.app.ws.repositories.EducationRepository;
import com.brightcoding.app.ws.repositories.OfferRepository;
import com.brightcoding.app.ws.services.NoteService;
@Service
public class NoteServiceImpl implements NoteService{

	@Autowired
	EducationRepository educationRepository;
	@Autowired
	CondidatOffreRepository condidatOffreRepository;
	@Autowired
	CondidatRepository condidatRepository;
	@Autowired
	OfferRepository offreRepository;
	
	@Override
	public float calculNote(long id) {
		float note =0;
	for(EducationEntity education:	condidatRepository.findById(id).get().getEducation()) {
		System.out.print("hi");
		note=note+calculAnnee(education);
				
	}
		return (note) ;
	}



	public float calculAnnee(EducationEntity education ) {
		float note=0;
		for (AnneeEducationEntity anneeEducation : education.getAnnees() ) {
			note=note+anneeEducation.getNote();
			
		}
		System.out.print(note);
		return (note/education.getAnnees().size());
	}




	@Override
	public CondidatOffreEntity noteFinal(long id,int offerid) {
		CondidatOffreEntity condidatOffreEntity=new CondidatOffreEntity ();
CondidatEntity candidate=condidatRepository.findById(id).get();
		
	

		condidatOffreEntity.setNote(calculNote(id)*3);
				
		condidatOffreRepository.save(condidatOffreEntity);
		candidate.getCondidatoffre().add(condidatOffreEntity);
		condidatRepository.save(candidate);
		OfferEntity offer =offreRepository.findById(offerid).get();
	offer.getCandidtes().add(condidatOffreEntity);
	offreRepository.save(offer);
		return condidatOffreEntity ;
		
	}



	@Override
	public CondidatOffreEntity noteTerminale(long id , float noteInterview) {
		
		CondidatOffreEntity condidatOffreEntity=condidatOffreRepository.findById(id).get();
		condidatOffreEntity.setNote(condidatOffreEntity.getNote()+noteInterview);
		
		condidatOffreRepository.save(condidatOffreEntity);
		return condidatOffreEntity ;
	}
	
	

}
