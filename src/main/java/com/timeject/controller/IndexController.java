package com.timeject.controller;

import com.timeject.model.Project;
import com.timeject.model.ProjectStatus;
import com.timeject.model.ProjectType;
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
	@GetMapping(value ={ "","/"})
	public String home(Model model){
		model.addAttribute("projects",projectService.findAll());
		model.addAttribute("project",getEmptyProject());
		return "index";
	}

	private Project getEmptyProject() {
		Project project = new Project();
		project.setType(new ProjectType());
		project.setStatus(new ProjectStatus());
		return project;
	}

	@GetMapping(value = "/thanos")
	public String thanos(){
		return "thanos";
	}
}