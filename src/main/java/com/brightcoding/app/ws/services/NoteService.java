package com.brightcoding.app.ws.services;

import com.brightcoding.app.ws.entities.AnneeEducationEntity;
import com.brightcoding.app.ws.entities.CondidatOffreEntity;

public interface NoteService {
	
//calcule du note de chaque education
	float calculNote(long id); 
 
	
	//note final pour la partie theorique
	CondidatOffreEntity noteFinal(long id, int offerid);
	
	
	//note final apres l'entretien
	CondidatOffreEntity noteTerminale(long id, float noteInterview);
	
	
}
