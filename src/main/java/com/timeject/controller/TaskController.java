package com.timeject.controller;

import java.util.Optional;

import javax.inject.Inject;

import com.timeject.util.RedirectAttributeKey;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;

import com.timeject.model.Task;
import com.timeject.repository.TaskRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/project/task")
public class TaskController {
	
	private final TaskRepository taskRepository;

	@Inject
	public TaskController(TaskRepository taskRepository){
		this.taskRepository = taskRepository;
	}
	@GetMapping("/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
		Task task = taskRepository.findById(id).get();
		String taskTitle = task.getTitle();
		Long projectId = task.getProjectId();
		taskRepository.deleteById(id);
		redirectAttributes.addAttribute(RedirectAttributeKey.SUCCESS_MESSAGE.name(),"Task \""+taskTitle+"\" deleted!");
		return "redirect:/project/"+projectId+"/view";

	}
}
