package com.brightcoding.app.ws.shared.dto;

import java.time.LocalDateTime;



import com.brightcoding.app.ws.entities.OfferEntity;
import com.brightcoding.app.ws.entities.Resource;



public class EventDto {
	

	    Long id;

	    String text;

	    LocalDateTime start;

	    LocalDateTime end;

	  
	    Resource resource;
	  
	    OfferEntity offer;
	
	    public Long getResourceId() {
	        return resource.getId();
	    }

	    public Integer getOfferId() {
	        return offer.getId();
	    }
	    public OfferEntity getOffer() {
	        return offer;
	    }

	    public void setOffer(OfferEntity offer) {
	        this.offer = offer;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getText() {
	        return text;
	    }

	    public void setText(String text) {
	        this.text = text;
	    }

	    public LocalDateTime getStart() {
	        return start;
	    }

	    public void setStart(LocalDateTime start) {
	        this.start = start;
	    }

	    public LocalDateTime getEnd() {
	        return end;
	    }

	    public void setEnd(LocalDateTime end) {
	        this.end = end;
	    }

	    public Resource getResource() {
	        return resource;
	    }

	    public void setResource(Resource resource) {
	        this.resource = resource;
	    }


}
