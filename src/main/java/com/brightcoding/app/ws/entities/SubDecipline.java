package com.brightcoding.app.ws.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class SubDecipline implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	     @Id
		 @GeneratedValue
		 private long id;
		 private String nom ;
		 private String image;
	    @ManyToOne
	    private SpecialiteEntity speciality;
	    @OneToMany(cascade = CascadeType.ALL,mappedBy="subDecipline" )
	     private List<Project> project;
	    
	    //getter and setters 
	    
	    
	    
	    
		public long getId() {
			return id;
		}
		
		public SubDecipline(long id, String nom, String image, SpecialiteEntity speciality, List<Project> project) {
			super();
			this.id = id;
			this.nom = nom;
			this.image = image;
			this.speciality = speciality;
			this.project = project;
		}
		public SubDecipline() {
		}
		public SubDecipline(long id, String nom, SpecialiteEntity speciality, List<Project> project) {
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
