package com.timeject.controller;

import com.timeject.model.Project;
import com.timeject.repository.ProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.inject.Inject;
import java.util.Optional;

@RestController
@RequestMapping(value = "/projects")
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
	
}
