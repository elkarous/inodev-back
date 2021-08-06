package com.brightcoding.app.ws.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Project implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
		@GeneratedValue
		 private long id;
		 private String description;
		 private String nom ;
		 private String acronyme;
		 @ManyToOne
		 private SubDecipline subDecipline;
		 
		  @OneToMany(cascade = CascadeType.ALL,mappedBy="project",fetch=FetchType.LAZY )
		     private List<OffreEntity> offers;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getAcronyme() {
			return acronyme;
		}

		public void setAcronyme(String acronyme) {
			this.acronyme = acronyme;
		}

		public SubDecipline getSubDecipline() {
			return subDecipline;
		}

		public void setSubDecipline(SubDecipline subDecipline) {
			this.subDecipline = subDecipline;
		}

		public List<OffreEntity> getOffers() {
			return offers;
		}

		public void setOffers(List<OffreEntity> offers) {
			this.offers = offers;
		}

		public Project() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Project(long id, String description, String nom, String acronyme, SubDecipline subDecipline,
				List<OffreEntity> offers) {
			super();
			this.id = id;
			this.description = description;
			this.nom = nom;
			this.acronyme = acronyme;
			this.subDecipline = subDecipline;
			this.offers = offers;
		}

		
		  
		  
		 
}
