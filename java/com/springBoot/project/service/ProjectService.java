package com.springBoot.project.service;

import java.util.List;
import com.springBoot.project.entity.Project;

public interface ProjectService {

	public String createProject(Project p);
	public boolean validateProject(int id);
	public List<Project> viewAllProject();
	public Project viewProject(int id);
	public String updateProject(int id, String description, String startdate, String endDate);
	public String deleteProject(int id);
}
