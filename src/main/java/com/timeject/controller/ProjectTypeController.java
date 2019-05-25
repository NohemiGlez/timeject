package com.timeject.controller;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.timeject.exception.NotFoundException;
import com.timeject.model.Project;
import com.timeject.service.ProjectService;
import com.timeject.service.ProjectTypeService;

@Controller
@RequestMapping(value = "/type")
public class ProjectTypeController {

	private final ProjectTypeService projectTypeService;

	@Inject
	public ProjectTypeController(ProjectTypeService projectTypeService) {
        this.projectTypeService= projectTypeService;
    }

	@GetMapping("/view")
	public String view(@PathVariable Long id, Model model) throws NotFoundException {
		Optional<Project> projectOptional = projectTypeService.findById(id);
		if (!projectOptional.isPresent()) {
			throw new NotFoundException("project searched couldn't be located");
		}
		model.addAttribute("project", projectTypeService.findById(id));
		return "project/view";
	}

}
