package com.brightcoding.app.ws.shared.dto;

import java.util.List;



import com.brightcoding.app.ws.entities.SubDecipline;

public class SpecialiteDto {
   
    private Integer id;
    private String  specialiteId;
    private String nom;
    private String image;
    
    private List<SubDecipline> subDecipline;

    public List<SubDecipline> getSubDecipline() {
		return subDecipline;
	}

	public void setSubDecipline(List<SubDecipline> subDecipline) {
		this.subDecipline = subDecipline;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecialiteId() {
        return specialiteId;
    }

    public void setSpecialiteId(String specialiteId) {
        this.specialiteId = specialiteId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

   
}



