package com.brightcoding.app.ws.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.brightcoding.app.ws.entities.Project;



public interface  ProjectRepository extends CrudRepository<Project, Long> {

    

}
