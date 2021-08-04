package com.brightcoding.app.ws.services;

import java.util.List;
import com.brightcoding.app.ws.shared.dto.ProjectDto;



public interface ProjectService {   List<ProjectDto> getAllProject(String email);

ProjectDto createProject(ProjectDto project, String email);

ProjectDto getProject(String projectId);
ProjectDto updateproject(Long Id, ProjectDto ProjectDto);
void deleteProject(Long projectId);

List<ProjectDto> getAllProject();



ProjectDto getProject(Long projectId);

ProjectDto createProject(ProjectDto project);

}
