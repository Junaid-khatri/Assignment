package com.springBoot.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.project.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Integer>{

}
