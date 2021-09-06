package com.brightcoding.app.ws.responses;

import com.brightcoding.app.ws.entities.AnneeEducationEntity;
import com.brightcoding.app.ws.entities.EducationEntity;
import com.brightcoding.app.ws.shared.dto.CondidatDto;

import java.util.Date;
import java.util.List;

public class EducationResponse {


    private long id;
    private String nomFaculte;
    private String pays;

    
    private Date dateDebut;
    private Date dateFin;
    private String nomDiplome;
    private String specialite;
    private String niveau;
    

    private List<AnneeEducationEntity> annees;
  //getter and setters
    
    public List<AnneeEducationEntity> getAnnees() {
		return annees;
	}

	public void setAnnees(List<AnneeEducationEntity> annees) {
		this.annees = annees;
	}


    private String educationId;


    public String getEducationId() {
        return educationId;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomFaculte() {
        return nomFaculte;
    }
   
    public void setNomFaculte(String nomFaculte) {
        this.nomFaculte = nomFaculte;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
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

    public String getNomDiplome() {
        return nomDiplome;
    }

    public void setNomDiplome(String nomDiplome) {
        this.nomDiplome = nomDiplome;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

	public EducationResponse(long id, String nomFaculte, String pays, Date dateDebut, Date dateFin, String nomDiplome,
			String specialite, String niveau, List<AnneeEducationEntity> annees, String educationId) {
		super();
		this.id = id;
		this.nomFaculte = nomFaculte;
		this.pays = pays;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nomDiplome = nomDiplome;
		this.specialite = specialite;
		this.niveau = niveau;
		this.annees = annees;
		this.educationId = educationId;
	}

	public EducationResponse() {
		// TODO Auto-generated constructor stub
	}
    
    
}
