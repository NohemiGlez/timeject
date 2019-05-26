package com.timeject.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.timeject.exception.NotFoundException;
import com.timeject.model.Project;
import com.timeject.service.ProjectService;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {
	private final ProjectService projectService;
	
	@Inject
	public ProjectController(ProjectService projectService) {
        this.projectService= projectService;
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model) throws NotFoundException {
		model.addAttribute("projects",projectService.findAll());
		model.addAttribute("project",projectService.findById(id));
		return "project/view";
	}

	@GetMapping("/{id}/edit")
	public String edit(@PathVariable Long id){
		return "project/edit";
	}

	@GetMapping("/{id}/delete")
	public void delete(@PathVariable Long id){

	}

	@PostMapping("/")
	public String add( @ModelAttribute("project") Project project, Model model) throws NotFoundException {
		projectService.save(project);
		return view(project.getId(),model);
	}

}
