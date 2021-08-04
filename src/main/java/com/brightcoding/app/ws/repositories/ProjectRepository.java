package com.brightcoding.app.ws.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brightcoding.app.ws.entities.Project;


@Repository
public interface  ProjectRepository extends CrudRepository<Project, Long> {

    

}
