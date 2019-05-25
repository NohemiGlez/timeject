package com.timeject.controller;

import java.util.Optional;

import javax.inject.Inject;

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

@Controller
@RequestMapping(value = "/task")
public class TaskController {
	
	private final TaskRepository taskRepository;

	@Inject
	public TaskController(TaskRepository taskRepository){
		this.taskRepository = taskRepository;
	}
}
