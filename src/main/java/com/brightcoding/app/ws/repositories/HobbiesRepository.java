package com.brightcoding.app.ws.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brightcoding.app.ws.entities.CondidatEntity;
import com.brightcoding.app.ws.entities.Hobbies;


@Repository
public interface HobbiesRepository extends CrudRepository<Hobbies, Long>{
	

}
