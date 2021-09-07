package com.brightcoding.app.ws.shared.dto;

import java.time.LocalDateTime;


import com.brightcoding.app.ws.entities.CondidatEntity;

import com.brightcoding.app.ws.entities.Status;

public class CondidatOffreDto {

	
	Long id;
    String condidatoffreId;
   
   
    CondidatEntity condidatEntity;
   

    private float noteinterview;
    private float notePortugal;
    private float score;

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

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
    
    }


  
