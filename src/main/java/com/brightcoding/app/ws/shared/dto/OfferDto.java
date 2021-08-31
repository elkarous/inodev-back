package com.brightcoding.app.ws.shared.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.brightcoding.app.ws.entities.Event;
import com.brightcoding.app.ws.entities.Project;
import com.brightcoding.app.ws.entities.SubDecipline;



public class OfferDto {
	
	
	   

	    
	    private Integer id;
	    private String image;
	    private String acronym;
	    private String adress;
	    private String type;
	    private String offerId;
	    private String nom;
	    private String organisation;

	  
	    private Date dateDebut;
	    private Date startdateoffer;
	    public Date getStartdateoffer() {
			return startdateoffer;
		}

		public void setStartdateoffer(Date startdateoffer) {
			this.startdateoffer = startdateoffer;
		}

		private Date dateFin;
	    private String description;
	    private String video;
	    private String duree;
	    private String niveau;
	    private Long prix;
	    private Long supervisor;
	    private String processus;
	  
	    List<CondidatOffreDto> condidatoffre;
	    private List<SkillsDto> skills;
	
	   private Project project;
	   
	    private List<Event> event;
	  
			
	    public Project getProject() {
			return project;
		}

		public void setProject(Project project) {
			this.project = project;
		}

		public Long getSupervisor() {
	        return supervisor;
	    }

	    public void setSupervisor(Long supervisor) {
	        this.supervisor = supervisor;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public List<Event> getEvent() {
	        return event;
	    }

	    public void setEvent(List<Event> event) {
	        this.event = event;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getImage() {
	        return image;
	    }

	    public void setImage(String image) {
	        this.image = image;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    

	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }
	    
	    

	    public String getAcronym() {
			return acronym;
		}

		public void setAcronym(String acronym) {
			this.acronym = acronym;
		}

		public String getAdress() {
			return adress;
		}

		public void setAdress(String adress) {
			this.adress = adress;
		}

		public String getOfferId() {
			return offerId;
		}

		public void setOfferId(String offerId) {
			this.offerId = offerId;
		}

		public String getOrganisation() {
	        return organisation;
	    }

	    public void setOrganisation(String organisation) {
	        this.organisation = organisation;
	    }

	    public Date getDateDebut() {
	        return dateDebut;
	    }

	    public void setDateDebut(Date dateDebut) {
	        this.dateDebut = dateDebut;
	    }

	    public Date getDateFin() {
	        return dateFin;
	    }

	    public void setDateFin(Date dateFin) {
	        this.dateFin = dateFin;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getVideo() {
	        return video;
	    }

	    public void setVideo(String video) {
	        this.video = video;
	    }

	    public Long getPrix() {
	        return prix;
	    }

	    public void setPrix(Long prix) {
	        this.prix = prix;
	    }

	    public String getProcessus() {
	        return processus;
	    }

	    public void setProcessus(String processus) {
	        this.processus = processus;
	    }

	    public List<CondidatOffreDto> getCondidatoffre() {
	        return condidatoffre;
	    }

	    public void setCondidatoffre(List<CondidatOffreDto> condidatoffre) {
	        this.condidatoffre = condidatoffre;
	    }

	    public List<SkillsDto> getSkills() {
	        return skills;
	    }

	    public void setSkills(List<SkillsDto> skills) {
	        this.skills = skills;
	    }

	 

	    public String getDuree() {
	        return duree;
	    }

	    public void setDuree(String duree) {
	        this.duree = duree;
	    }

	    public String getNiveau() {
	        return niveau;
	    }

	    public void setNiveau(String niveau) {
	        this.niveau = niveau;
	    }

	    @Override
	    public String toString() {
	        return "Offer [id=" + id + ", image=" + image + ", type=" + type + ", offerId=" + offerId + ", nom=" + nom
	                + ", organisation=" + organisation + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", description=" + description + ", video=" + video
	                + ", prix=" + prix + ", processus=" + processus +" , duree=" + duree + ", niveau=" + niveau + "]";
	    }
	    public OfferDto () {
	        super();
	    }

		public OfferDto(Integer id, String image, String type, String offerId, String nom, String organisation,
				Date dateDebut, Date dateFin, String description, String video, String duree, String niveau, Long prix,
				Long supervisor, String processus, List<CondidatOffreDto> condidatoffre, List<SkillsDto> skills,
				Project project, List<Event> event) {
			super();
			this.id = id;
			this.image = image;
			this.type = type;
			this.offerId = offerId;
			this.nom = nom;
			this.organisation = organisation;
			this.dateDebut = dateDebut;
			this.dateFin = dateFin;
			this.description = description;
			this.video = video;
			this.duree = duree;
			this.niveau = niveau;
			this.prix = prix;
			this.supervisor = supervisor;
			this.processus = processus;
			this.condidatoffre = condidatoffre;
			this.skills = skills;
			this.project = project;
			this.event = event;
		}

	}

