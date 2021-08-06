package com.brightcoding.app.ws.services;

import java.util.List;
import com.brightcoding.app.ws.shared.dto.ProjectDto;



public interface ProjectService {   

List<ProjectDto> getAllProject();

ProjectDto createProject(ProjectDto project);

ProjectDto getProject(Long projectId);

ProjectDto updateproject(Long Id, ProjectDto projectDto);

void deleteProject(Long ProjectId);

}
