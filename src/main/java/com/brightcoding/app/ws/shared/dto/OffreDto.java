package com.brightcoding.app.ws.shared.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.brightcoding.app.ws.entities.Event;
import com.brightcoding.app.ws.entities.Project;
import com.brightcoding.app.ws.entities.SubDecipline;



public class OffreDto {
	
	
	   

	    
	    private Integer id;
	    private String image;
	  
	    private String type;
	    private String offreId;
	    private String nom;
	    private String organisation;

	  
	    private Date dateDebut;

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

	    public String getOffreId() {
	        return offreId;
	    }

	    public void setOffreId(String offreId) {
	        this.offreId = offreId;
	    }

	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
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
	        return "Offre [id=" + id + ", image=" + image + ", type=" + type + ", offreId=" + offreId + ", nom=" + nom
	                + ", organisation=" + organisation + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", description=" + description + ", video=" + video
	                + ", prix=" + prix + ", processus=" + processus +" , duree=" + duree + ", niveau=" + niveau + "]";
	    }
	    public OffreDto () {
	        super();
	    }

	}

