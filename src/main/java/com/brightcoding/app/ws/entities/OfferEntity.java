package com.brightcoding.app.ws.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "offer")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class OfferEntity implements Serializable {
	
  
	private static final long serialVersionUID = -5763827745308343856L;

    @GeneratedValue
    @Id
    private Integer id;
    private String image;
    private String acronym;
    private String type;
    private String offerId;
    private String nom;

    private String organisation;
    private String adress;

   


    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
   

	@Temporal(TemporalType.DATE)
    private Date startdateoffer;
    private String description;
    private String video;
    private String duree;
    private String niveau;
    private Long prix;
    private Long supervisor;
    private String processus;
    @OneToOne(cascade = CascadeType.ALL )
    CondidatOffreEntity condidatoffre;
    @OneToMany(cascade = CascadeType.ALL )
    private List<SkillsEntity> skills;
  
    @OneToMany(cascade = CascadeType.ALL,mappedBy="offer" )
    private List<Event> event;
   


  //getter and setters

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

    public String getofferId() {
        return offerId;
    }

    public void setofferId(String offerId) {
        this.offerId = offerId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
    
    public Date getStartdateoffer() {
		return startdateoffer;
	}

	public void setStartdateoffer(Date startdateoffer) {
		this.startdateoffer = startdateoffer;
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



    public OfferEntity(Integer id, String image, String acronym, String type, String offerId, String nom,
			 Date dateDebut, Date dateFin, String description, String video, String duree,
			String niveau, Long prix, Long supervisor, String processus, CondidatOffreEntity condidatoffre,
			List<SkillsEntity> skills, List<Event> event) {
		super();
		this.id = id;
		this.image = image;
		this.acronym = acronym;
		this.type = type;
		this.offerId = offerId;
		this.nom = nom;
		
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
		this.event = event;
	}

	public CondidatOffreEntity getCondidatoffre() {
		return condidatoffre;
	}

	public void setCondidatoffre(CondidatOffreEntity condidatoffre) {
		this.condidatoffre = condidatoffre;
	}

	public List<SkillsEntity> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillsEntity> skills) {
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

 
    public OfferEntity () {
        super();
    }

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

}
