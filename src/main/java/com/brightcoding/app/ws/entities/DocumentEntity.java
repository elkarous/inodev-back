package com.brightcoding.app.ws.entities;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
public class DocumentEntity implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    private Integer id;
    private String  documentId;
    private String nom;
 
  //getter and setters

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   
}
