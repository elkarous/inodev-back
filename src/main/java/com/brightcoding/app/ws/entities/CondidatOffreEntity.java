package com.brightcoding.app.ws.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "condidatOffre")
public class CondidatOffreEntity {

    @Id
    @GeneratedValue
    Long id;
    String condidatoffreId;
    @ManyToOne
    CondidatEntity condidat;

    @ManyToOne
    OfferEntity offer;

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

    public OfferEntity getoffer() {
        return offer;
    }

    public void setoffer(OfferEntity offer) {
        this.offer = offer;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }
    }

  
