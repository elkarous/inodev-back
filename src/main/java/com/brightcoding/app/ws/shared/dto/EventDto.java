package com.brightcoding.app.ws.shared.dto;

import java.time.LocalDateTime;



import com.brightcoding.app.ws.entities.OffreEntity;
import com.brightcoding.app.ws.entities.Resource;


public class EventDto {
	
	public class Event {

	    
	    Long id;

	    String text;

	    LocalDateTime start;

	    LocalDateTime end;

	    Resource resource;
	  
	    OffreEntity offre;
	 
	    public Long getResourceId() {
	        return resource.getId();
	    }
	    public Integer getOffreId() {
	        return offre.getId();
	    }
	    public OffreEntity getOffre() {
	        return offre;
	    }

	    public void setOffre(OffreEntity offre) {
	        this.offre = offre;
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
}
