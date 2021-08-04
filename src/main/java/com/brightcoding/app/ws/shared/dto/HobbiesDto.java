package com.brightcoding.app.ws.shared.dto;



import com.brightcoding.app.ws.entities.CondidatEntity;

public class HobbiesDto {
	private long id;
    private String nom ;
    private String description;
    
 
    private CondidatEntity condidat;
    
    //getters and Setters 
    
	public long getId() {
		return id;
	}
	public HobbiesDto(long id, String nom, String description, CondidatEntity condidat) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.condidat = condidat;
	}
	public HobbiesDto() {
		super();
		// TODO Auto-generated constructor stub
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


