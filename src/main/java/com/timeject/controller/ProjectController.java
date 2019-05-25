package com.timeject.controller;

import java.util.Optional;

import javax.inject.Inject;

import com.timeject.exception.NotFoundException;
import com.timeject.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping(value = "/project/{id}")
public class ProjectController {
	
	private final ProjectService projectService;
	
	@Inject
	public ProjectController(ProjectService projectService) {
        this.projectService= projectService;
    }

    @GetMapping("/view")
    public String view(@PathVariable Long id, Model model) throws NotFoundException {
		Optional<Project> projectOptional = projectService.findById(id);
		if(!projectOptional.isPresent()){
			throw new NotFoundException("project searched couldn't be located");
		}
		model.addAttribute("project",projectService.findById(id));
		return "project/view";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id){
		return "project/edit";
	}

	@GetMapping("{id}/delete")
	public void delete(@PathVariable Long id){

	}



}
