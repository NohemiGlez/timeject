package com.timeject.controller;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.timeject.model.ProjectType;
import com.timeject.service.ProjectTypeService;

@Controller
public class ProjectTypeController {

	private final ProjectTypeService projectTypeService;

	@Inject
	public ProjectTypeController(ProjectTypeService projectTypeService) {
        this.projectTypeService= projectTypeService;
    }

	@RequestMapping(value = "/types")
	public @ResponseBody Iterable<ProjectType> view() {
		return projectTypeService.findAll();
	}

}
