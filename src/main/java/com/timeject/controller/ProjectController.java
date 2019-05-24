package com.timeject.controller;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;

import com.timeject.model.Project;
import com.timeject.repository.ProjectRepository;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {
	
	private final ProjectRepository projectRepository;
	
	@Inject
	public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Project> getAllProjects(){
		return projectRepository.findAll();
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public Project addProject(@RequestBody Project project) {
		projectRepository.save(project);
		Optional<Project> projectOptional = projectRepository.findById(project.getId());
		if (!projectOptional.isPresent())
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"unable to store project");
		return projectOptional.get();
	}
	
	@PutMapping(value = "/{projectName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Project updateProject(@RequestBody Project project) {
		
		Optional<Project> projectOptional = projectRepository.findById(project.getId());
		projectRepository.save(projectOptional);
		if (!projectOptional.isPresent())
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"unable to update project");
		return projectOptional.get();
	} 
	
	@DeleteMapping(value = "/{projectName}")
	public void deleteProject(@PathVariable final String projectName) {
		Optional<Project> projectOptional = projectRepository.findByName(projectName);
		projectRepository.delete(projectOptional);
		if (!projectOptional.isPresent())
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"unable to delete project");
	}
}
