package com.brightcoding.app.ws.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brightcoding.app.ws.entities.SubDecipline;


@Repository
public interface SubDeciplineRepository extends CrudRepository<SubDecipline, Long> {
	
public  SubDecipline findByNom(String nom);
}
