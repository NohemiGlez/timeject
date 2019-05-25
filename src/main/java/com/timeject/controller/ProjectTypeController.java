package com.timeject.controller;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.timeject.exception.NotFoundException;
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
	public Model view(@PathVariable Long id, Model model) throws NotFoundException {
		Iterable<ProjectType> projectTypeOptional = projectTypeService.findAll();
		return model.addAttribute("project", projectTypeOptional);
	}

}
