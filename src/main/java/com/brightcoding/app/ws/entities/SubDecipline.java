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
	   
	    @OneToMany(cascade = CascadeType.ALL )
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
			
			this.project = project;
		}
		public SubDecipline() {
		}
		public SubDecipline(long id, String nom, SpecialiteEntity speciality, List<Project> project) {
			super();
			this.id = id;
			this.nom = nom;
		
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
