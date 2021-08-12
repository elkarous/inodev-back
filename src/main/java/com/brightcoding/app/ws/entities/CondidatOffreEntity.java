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
   
    @OneToOne
    CondidatEntity condidatEntity;
    @OneToOne
    OfferEntity offer;

    public OfferEntity getOffer() {
		return offer;
	}

	public void setOffer(OfferEntity offer) {
		this.offer = offer;
	}

	public CondidatEntity getCondidatEntity() {
		return condidatEntity;
	}

	public void setCondidatEntity(CondidatEntity condidatEntity) {
		this.condidatEntity = condidatEntity;
	}

	LocalDateTime registeredAt;

  private Status status;
    
    private float note;

    public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public float getNote() {
		return note;
	}

	public float setNote(float note) {
		return this.note = note;
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

 

   
    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }
    }

  
