package com.brightcoding.app.ws.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.brightcoding.app.ws.entities.OfferEntity;
import com.brightcoding.app.ws.shared.dto.CondidatDto;
import com.brightcoding.app.ws.shared.dto.OfferDto;

public interface OfferService {

	List<OfferDto> getAllOffre();

	OfferDto createOffre(OfferDto offerDto);

	



	void deleteOffre(int OfferId);

	OfferDto updateOffre(int Id, OfferDto OfferDto);


	OfferDto getOffre(int OfferId);

	List<OfferEntity> findOffrebySpe(String nom);

		List<OfferEntity> getOffreByDuree(String duree);

	List<OfferEntity> getOffreByNiveau(String niveau);

	List<OfferEntity> findBysearch(@Param(value = "specialite")String nom, @PathVariable(value = "duree") String duree,@Param(value = "niveau")String niveau);

	List<OfferEntity> getOffreBySupervisor(String supervisor);

	


	



	

	



	


	//List<OfferDto> getOfferByAll(String nom, String search, String niveau);

	

	






}
