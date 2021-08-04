package com.brightcoding.app.ws.shared.dto;

import java.time.LocalDateTime;


import com.brightcoding.app.ws.entities.CondidatEntity;
import com.brightcoding.app.ws.entities.OffreEntity;
import com.brightcoding.app.ws.entities.Status;

public class CondidatOffreDto {

	
    Long id;
    String condidatoffreId;
    CondidatEntity condidat;
    OffreEntity offre;
    LocalDateTime registeredAt;

  private Status status;
    
    private int note;

    public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCondidatoffreId() {
        return condidatoffreId;
    }

    public void setCondidatoffreId(String condidatoffreId) {
        this.condidatoffreId = condidatoffreId;
    }

    public CondidatEntity getCondidat() {
        return condidat;
    }

    public void setCondidat(CondidatEntity condidat) {
        this.condidat = condidat;
    }

    public OffreEntity getOffre() {
        return offre;
    }

    public void setOffre(OffreEntity offre) {
        this.offre = offre;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }
    }

  
