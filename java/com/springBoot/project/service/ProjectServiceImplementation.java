package com.springBoot.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.project.entity.Project;
import com.springBoot.project.repository.ProjectRepository;

@Service
public class ProjectServiceImplementation implements ProjectService{

	@Autowired
	ProjectRepository pr;
	
	
	@Override
	public String createProject(Project p) {
		try {
			
		
		if(validateProject(p.getId())) {
			pr.save(p);
			return "projectSaved";
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return "prjectAlreadyExist";
		
	}


	@Override
	public boolean validateProject(int id) {
		Project pro = null; 
		try {
			pro = pr.findById(id).get();
			return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return true;
		}
			
	}


	@Override
	public List<Project> viewAllProject() {
		return pr.findAll();
	}


	@Override
	public Project viewProject(int id) {
		if(!(validateProject(id))) {
			pr.deleteById(id);
			return pr.findById(id).get();
		}
		return null;
	}


	@Override
	public String updateProject(int id, String description, String startdate, String endDate) {
		if(!(validateProject(id))) {
			Project p = pr.findById(id).get();
			p.setDescription(description);
			p.setStartdate(startdate);
			p.setEndDate(endDate);
			pr.save(p);
			return "Project is Updated";
		}
		return "With this id project doesn't exist";
	}


	@Override
	public String deleteProject(int id) {
		if(!(validateProject(id))) {
			pr.deleteById(id);
			return "Project is deleted";
		}
		return "With this id project doesn't exist";
	}
}
