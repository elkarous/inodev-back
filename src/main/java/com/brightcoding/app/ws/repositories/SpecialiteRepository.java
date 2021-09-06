package com.brightcoding.app.ws.repositories;

import com.brightcoding.app.ws.entities.OfferEntity;
import com.brightcoding.app.ws.entities.SpecialiteEntity;
import com.brightcoding.app.ws.entities.SubDecipline;
import com.brightcoding.app.ws.responses.SpecialiteResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialiteRepository extends JpaRepository<SpecialiteEntity, Integer> {

    SpecialiteEntity findBySpecialiteId(String id);
    @Query("SELECT t FROM SpecialiteEntity t where t.nom = :name")
    List findByName(@Param("name") String name);
    
    @Query("SELECT t FROM SpecialiteEntity t")
    List findbycat();
   
    @Query("SELECT MAX (t.id) FROM OfferEntity t")
    Integer maxId();
	SpecialiteEntity findByNom(String nom);
}
