package com.brightcoding.app.ws.repositories;

import com.brightcoding.app.ws.entities.OffreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OffreRepository extends JpaRepository<OffreEntity, Integer> {
    OffreEntity findByOffreId(@Param(value = "id") String id);
    @Query("SELECT t FROM OffreEntity t where t.id = :id")
    OffreEntity findByaId(@Param(value = "id") Integer id);
    @Query("SELECT t.id, t.nom, t.image, t.id, t.duree, t.dateFin, t.description, t.organisation," +
            " t.prix, t.processus, t.type, t.offreId, t.video FROM OffreEntity t where t.type = :type and t.dateFin >= current_date ")
    List findAll(@Param(value = "type")String type);
    @Query("SELECT t.id, t.nom, t.image, t.id, t.duree, t.dateFin, t.description, t.organisation," +
            " t.prix, t.processus, t.type, t.offreId, t.video FROM OffreEntity t where t.dateFin >= current_date ")
    List findAllcurrent();
    @Query("SELECT t.id, t.nom, t.image, t.id, t.duree, t.dateFin, t.description, t.organisation," +
            " t.prix, t.processus, t.type, t.offreId, t.video FROM OffreEntity t where t.type = :type ")
    List<OffreEntity> findaAll(@Param(value = "type") String type);
    @Query("SELECT t.offreId, t.nom, t.id, t.supervisor, t.dateFin, t.duree, t.id FROM OffreEntity t")
    List findAllByNom();
    @Query("SELECT t.id, t.nom, t.image, t.id, t.dateDebut, t.dateFin, t.description, t.organisation," +
            " t.prix, t.processus, t.duree, t.niveau, t.type, t.offreId, t.video FROM OffreEntity t where t.id = :id and t.type = :type ")
    List findByid(@Param(value = "id") Integer id, @Param(value = "type")String type);
    @Query("SELECT t.id, t.nom, t.image, t.id, t.dateDebut, t.dateFin, t.description, t.organisation," +
            " t.prix, t.processus, t.duree, t.niveau, t.type, t.offreId, t.video FROM OffreEntity t, SpecialiteEntity s where s.nom = :id and s.offre.id = t.id and t.type = :type and t.dateFin >= current_date ")
    List findBycat(@Param(value = "id")String id,@Param(value = "type") String type);
    @Query("SELECT t.id, t.nom, t.image, t.id, t.dateDebut, t.dateFin, t.description, t.organisation," +
            " t.prix, t.processus, t.duree, t.niveau, t.type, t.offreId, t.video FROM OffreEntity t, SpecialiteEntity s where s.nom = :id and s.offre.id = t.id and t.type = :type and t.dateFin >= current_date ")
    List findBycategorie(@Param(value = "id") String id,@Param(value = "type") String type);


    @Query("SELECT t.id, t.nom, t.image, t.id, t.dateDebut, t.dateFin, t.description, t.organisation," +
            " t.prix, t.processus, t.duree, t.niveau, t.type, t.offreId, t.video FROM OffreEntity t, SpecialiteEntity s " +
            "where s.nom = :spe and s.offre.id = t.id and t.niveau = :niveau and t.duree = :duree and t.type = :type and t.dateFin >= current_date")
    List findBysearch(@Param(value = "spe")String spe,@Param(value = "duree") String duree, @Param(value = "niveau")String niveau, @Param(value = "type")String type);

    @Query("SELECT t.id, t.nom, t.image, t.id, t.dateDebut, t.dateFin, t.description, t.organisation," +
            " t.prix, t.processus, t.duree, t.niveau, t.type, t.offreId, t.video FROM OffreEntity t " +
            " where t.niveau = :niveau and t.duree = :duree and t.type = :type and t.dateFin >= current_date")
    List findByspenull( @Param(value = "duree")String duree,@Param(value = "niveau") String niveau,@Param(value = "type") String type);

    @Query("SELECT t.id, t.nom, t.image, t.id, t.dateDebut, t.dateFin, t.description, t.organisation," +
            " t.prix, t.processus, t.duree, t.niveau, t.type, t.offreId, t.video FROM OffreEntity t, SpecialiteEntity s " +
                "where s.nom = :spe and s.offre.id = t.id and t.duree = :duree and t.type = :type and t.dateFin >= current_date")
    List findBynivnull(@Param(value = "spe")String spe, @Param(value = "duree") String duree, @Param(value = "type") String type);

    @Query("SELECT t.id, t.nom, t.image, t.id, t.dateDebut, t.dateFin, t.description, t.organisation," +
            " t.prix, t.processus, t.duree, t.niveau, t.type, t.offreId, t.video FROM OffreEntity t, SpecialiteEntity s " +
            "where s.nom = :spe and s.offre.id = t.id and t.niveau = :niveau and t.type = :type and t.dateFin >= current_date")
    List findBydurnull(@Param(value = "spe")String spe,@Param(value = "niveau") String niveau, @Param(value = "type")String type);

    @Query("SELECT t.id, t.nom, t.image, t.id, t.dateDebut, t.dateFin, t.description, t.organisation," +
            " t.prix, t.processus, t.duree, t.niveau, t.type, t.offreId, t.video FROM OffreEntity t " +
            "where  t.niveau = :niveau and t.type = :type and t.dateFin >= current_date")
    List findBysdnull( @Param(value = "niveau") String niveau,@Param(value = "type") String type);

    @Query("SELECT t.id, t.nom, t.image, t.id, t.dateDebut, t.dateFin, t.description, t.organisation," +
            " t.prix, t.processus, t.duree, t.niveau, t.type, t.offreId, t.video FROM OffreEntity t " +
            "where t.duree = :duree and t.type = :type and t.dateFin >= current_date")
    List findBynsnull(@Param(value = "duree")String duree, @Param(value = "type")String type);

}
