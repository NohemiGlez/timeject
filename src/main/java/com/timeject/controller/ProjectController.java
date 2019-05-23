package com.timeject.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timeject.model.Project;
import com.timeject.repository.ProjectRepository;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
	
	private final ProjectRepository projectRepository;
	
	@Inject
	public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Project> getAllProjects(){
		return projectRepository.findAll();
	}

	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public Project addProject(@RequestBody Project project) {
		projectRepository.save(project);
		return projectRepository.findByName();
	}
	
}
