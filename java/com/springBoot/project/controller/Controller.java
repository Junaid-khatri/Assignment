package com.springBoot.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.project.entity.Project;
import com.springBoot.project.service.ProjectServiceImplementation;
import com.springBoot.project.service.ProjectService;


@RestController
public class Controller {
	
	@Autowired
	ProjectServiceImplementation ps;
	
	@PostMapping("/createProject")
	public String createProject(@RequestBody Project p) {
		String s = ps.createProject(p);
		return s;
	}
	@GetMapping("/ViewProjects")
	public List<Project> viewProject(){
		return ps.viewAllProject();
	}
	@GetMapping("/ViewProject/{id}")
	public Project viewProject(@PathVariable int id){
		return ps.viewProject(id);
	}
	@PostMapping("/updateProject")
	public String updateProject(@RequestParam int id,@RequestParam String description, @RequestParam String startdate,@RequestParam String endDate) {
		return ps.updateProject(id, description, startdate, endDate);
	}
	 @DeleteMapping("/deleteProject/{id}")
	 public String deleteProject(@PathVariable int id) {
		 return ps.deleteProject(id);
	 }
	 
	

}
