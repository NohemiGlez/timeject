package com.timeject.controller;

import javax.inject.Inject;

import com.timeject.util.RedirectAttributeKey;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.timeject.exception.NotFoundException;
import com.timeject.model.Project;
import com.timeject.service.ProjectService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@GetMapping("{id}/edit")
	public String edit(@ModelAttribute("project") Project project, Model model, RedirectAttributes redirectAttributes) throws NotFoundException{
		projectService.update(project);
		redirectAttributes.addAttribute(RedirectAttributeKey.SUCCESS_MESSAGE.name(),"Project \""+ project.getName() +"\" updated!");
		return "redirect:/";
	}

	@GetMapping("/{id}/delete")
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) throws NotFoundException {
		String projectName = projectService.findById(id).getName();
		projectService.deleteById(id);
		redirectAttributes.addAttribute(RedirectAttributeKey.SUCCESS_MESSAGE.name(),"Project \""+projectName+"\" deleted!");
		return "redirect:/";
	}

	@PostMapping("/")
	public String add( @ModelAttribute("project") Project project, Model model) throws NotFoundException {
		projectService.save(project);
		return view(project.getId(),model);
	}

}
