package com.brightcoding.app.ws.services;

import java.util.List;

import com.brightcoding.app.ws.entities.OffreEntity;
import com.brightcoding.app.ws.entities.Project;
import com.brightcoding.app.ws.entities.SubDecipline;
import com.brightcoding.app.ws.shared.dto.OffreDto;
import com.brightcoding.app.ws.shared.dto.ProjectDto;
import com.brightcoding.app.ws.shared.dto.SubDeciplineDto;



public interface SubDeciplineService {
	List<SubDeciplineDto> getAllSubdecipline();

    SubDeciplineDto createSubDecipline(SubDeciplineDto subDeciplineDto);

    SubDeciplineDto getSubDeciplineById(long subDeciplineId);
    SubDeciplineDto updateSubdecipline(Long Id, SubDeciplineDto subDeciplineDto);
    void deleteSubdecipline(long subDeciplineId);



	

	List<OffreEntity> findOffrebySub(String nom);





	

}
