package com.brightcoding.app.ws.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hobbies implements Serializable{
	    /**
	 * 
	 */
	private static final long serialVersionUID = -497975594521251861L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
	    private String nom ;
	    private String description;
	    

	   

	  

	    
	    //getters and Setters 
	    
		public long getId() {
			return id;
		}
		public Hobbies() {
			super();
			// TODO Auto-generated constructor stub
		}

	

		public Hobbies(long id, String nom, String description, CondidatEntity condidat) {
			super();
			this.id = id;
			this.nom = nom;
			this.description = description;
			
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		} 
	    

}
