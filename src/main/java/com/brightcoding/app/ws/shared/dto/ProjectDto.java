package com.brightcoding.app.ws.shared.dto;

import java.util.List;


import com.brightcoding.app.ws.entities.OfferEntity;
import com.brightcoding.app.ws.entities.SubDecipline;

public class ProjectDto {
	
		 private long id;
		 private String description;
		 private String nom ;
		 private String acronyme;
		
		 private SubDecipline subDecipline;
		 
	
		     private List<OfferDto> offers;

		public ProjectDto() {
				super();
				// TODO Auto-generated constructor stub
			}
		

		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public long getId() {
			return id;
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

		public ProjectDto(long id, String description, String nom, String acronyme, SubDecipline subDecipline,
				List<OfferDto> offers) {
			super();
			this.id = id;
			this.description = description;
			this.nom = nom;
			this.acronyme = acronyme;
			this.subDecipline = subDecipline;
			this.offers = offers;
		}

		public List<OfferDto> getOffers() {
			return offers;
		}

		public void setOffers(List<OfferDto> offers) {
			this.offers = offers;
		}

	}

		
		  

	