package com.timeject.controller;

import com.timeject.model.Project;
import com.timeject.service.ProjectService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
	private ProjectService projectService;
	public IndexController(ProjectService projectService){
		this.projectService = projectService;
	}
	@GetMapping(value = "",produces = {MediaType.APPLICATION_JSON_VALUE})
	public String home(Model model){
		model.addAttribute("projects",projectService.findAll());
		return "index";
	}

}