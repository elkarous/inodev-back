package com.brightcoding.app.ws.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Hobbies implements Serializable{
	    /**
	 * 
	 */
	private static final long serialVersionUID = -497975594521251861L;
		@Id
		@GeneratedValue
		private long id;
	    private String nom ;
	    private String description;
	    
	    @ManyToOne
	    private CondidatEntity condidat;
	    
	    //getters and Setters 
	    
		public long getId() {
			return id;
		}
		public CondidatEntity getCondidat() {
			return condidat;
		}
		public void setCondidat(CondidatEntity condidat) {
			this.condidat = condidat;
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
