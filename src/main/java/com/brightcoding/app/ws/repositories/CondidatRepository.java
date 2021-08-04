package com.brightcoding.app.ws.repositories;

import com.brightcoding.app.ws.entities.CondidatEntity;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CondidatRepository extends PagingAndSortingRepository<CondidatEntity, Long>{
    @Query("SELECT condidat FROM CondidatEntity condidat")
    Page<CondidatEntity> findAllCondidats(Pageable pageableRequest);
    @Query("FROM CondidatEntity condidat")
    List<CondidatEntity> findAllaCondidats();
    Boolean existsByEmail(String email);
    CondidatEntity findByUserId(String userId);

  
    Optional<CondidatEntity> findByEmail(String email);

    @Query(value="SELECT * FROM condidats c WHERE (c.first_name LIKE %:search% OR c.last_name LIKE %:search%) AND c.email_verification_status = :status", nativeQuery=true)
    Page<CondidatEntity> findAllCondidatByCriteria(Pageable pageableRequest, @Param("search") String search, @Param("status") int status);
    
    @Query(value="SELECT * FROM users u WHERE (u.first_name LIKE %:search% OR u.last_name LIKE %:search%) AND u.email_verification_status = :status", nativeQuery=true)
	Page<CondidatEntity> findAllUserByCriteria(Pageable pageableRequest, @Param("search") String search, @Param("status") int status);

	Optional<CondidatEntity> findUserByResetToken(String token);
}
