package com.brightcoding.app.ws.repositories;

import com.brightcoding.app.ws.entities.EducationEntity;


import org.springframework.data.repository.CrudRepository;

public interface EducationRepository extends CrudRepository<EducationEntity, Long> {
    
    EducationEntity findByEducationId(String educationId);
    public EducationEntity save(EducationEntity edducation);
	

	
}
