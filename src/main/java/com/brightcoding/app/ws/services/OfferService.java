package com.brightcoding.app.ws.services;

import java.util.List;

import com.brightcoding.app.ws.shared.dto.OfferDto;

public interface OfferService {

	List<OfferDto> getAllOffre();

	OfferDto createOffre(OfferDto offerDto);

	



	void deleteOffre(int OfferId);

	OfferDto updateOffre(int Id, OfferDto OfferDto);


	OfferDto getOffre(int OfferId);





}
