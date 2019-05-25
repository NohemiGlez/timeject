package com.timeject.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.timeject.model.ProjectStatus;
import com.timeject.service.ProjectStatusService;

@Controller
public class ProjectStatusController {

	private final ProjectStatusService projectStatusService;

	@Inject
	public ProjectStatusController(ProjectStatusService projectStatusService) {
        this.projectStatusService= projectStatusService;
    }

	@RequestMapping(value = "/status")
	public @ResponseBody Iterable<ProjectStatus> view() {
		return projectStatusService.findAll();
	}

}
