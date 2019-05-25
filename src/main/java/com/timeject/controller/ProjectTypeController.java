package com.timeject.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.timeject.model.ProjectType;
import com.timeject.service.ProjectTypeService;

@Controller
@RequestMapping(value = "/types")
public class ProjectTypeController {

	private final ProjectTypeService projectTypeService;

	@Inject
	public ProjectTypeController(ProjectTypeService projectTypeService) {
        this.projectTypeService= projectTypeService;
    }

	@GetMapping("/view")
	public Iterable<ProjectType> view() {
		return projectTypeService.findAll();
	}

}
