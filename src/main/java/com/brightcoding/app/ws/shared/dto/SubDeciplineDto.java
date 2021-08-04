package com.brightcoding.app.ws.shared.dto;

import java.util.List;



import com.brightcoding.app.ws.entities.Project;
import com.brightcoding.app.ws.entities.SpecialiteEntity;

public class SubDeciplineDto {

	
   
	 private long id;
	 private String nom ;
	 private String image;

   private SpecialiteEntity speciality;
  
    private List<Project> project;
   
   //getter and setters 
   
   
   
   
	public long getId() {
		return id;
	}
	public SubDeciplineDto(long id, String nom, String image, SpecialiteEntity speciality, List<Project> project) {
		super();
		this.id = id;
		this.nom = nom;
		this.image = image;
		this.speciality = speciality;
		this.project = project;
	}
	public SubDeciplineDto() {
	}
	public SubDeciplineDto(long id, String nom, SpecialiteEntity speciality, List<Project> project) {
		super();
		this.id = id;
		this.nom = nom;
		this.speciality = speciality;
		this.project = project;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public SpecialiteEntity getSpeciality() {
		return speciality;
	}
	public void setSpeciality(SpecialiteEntity speciality) {
		this.speciality = speciality;
	}
	public List<Project> getProject() {
		return project;
	}
	public void setProject(List<Project> project) {
		this.project = project;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
   
   
  
   
   
   
   
	 
}
