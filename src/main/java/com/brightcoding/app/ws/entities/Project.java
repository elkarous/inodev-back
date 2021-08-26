package com.brightcoding.app.ws.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

		 private String partenar;
		 @Temporal(TemporalType.DATE)
		    private Date endDate;

		 private String partener;
		 private String orginistaion;

		 
		  public String getPartenar() {
			return partenar;
		}

		public void setPartenar(String partenar) {
			this.partenar = partenar;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY )
		     private List<OfferEntity> offers;

		//getter and setters
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

	

		public List<OfferEntity> getOffers() {
			return offers;
		}

		public void setOffers(List<OfferEntity> offers) {
			this.offers = offers;
		}

		public Project() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Project(long id, String description, String nom, String acronyme, SubDecipline subDecipline,
				List<OfferEntity> offers) {
			super();
			this.id = id;
			this.description = description;
			this.nom = nom;
			this.acronyme = acronyme;
			
			this.offers = offers;
		}

		public String getPartener() {
			return partener;
		}

		public void setPartener(String partener) {
			this.partener = partener;
		}

		public String getOrginistaion() {
			return orginistaion;
		}

		public void setOrginistaion(String orginistaion) {
			this.orginistaion = orginistaion;
		}

		
		  
		  
		 
}
