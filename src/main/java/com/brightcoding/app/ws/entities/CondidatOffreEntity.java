package com.brightcoding.app.ws.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "condidatOffre")
public class CondidatOffreEntity {

    @Id
    @GeneratedValue
    Long id;
    String condidatoffreId;
   
    @OneToOne
    CondidatEntity condidatEntity;
    
    
    @OneToMany
    List<DocumentEntity> documents;
    
    
    public List<DocumentEntity> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentEntity> documents) {
		this.documents = documents;
	}

  //getter and setters


	public CondidatEntity getCondidatEntity() {
		return condidatEntity;
	}

	public void setCondidatEntity(CondidatEntity condidatEntity) {
		this.condidatEntity = condidatEntity;
	}

	LocalDateTime registeredAt;

  private Status status;
    
    private float note;
    private float noteinterview;
    private float notePortugal;
    
    public float getNoteinterview() {
		return noteinterview;
	}

	public void setNoteinterview(float noteinterview) {
		this.noteinterview = noteinterview;
	}

	public float getNotePortugal() {
		return notePortugal;
	}

	public void setNotePortugal(float notePortugal) {
		this.notePortugal = notePortugal;
	}

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

  
