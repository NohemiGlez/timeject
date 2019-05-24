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
	public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Task> getAllTasks(){
		return taskRepository.findAll();
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public Task addTask(@RequestBody Task task) {
		taskRepository.save(task);
		Optional<Task> taskOptional = taskRepository.findById(task.getId());
		if (!taskOptional.isPresent())
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"unable to store task");
		return taskOptional.get();
	}
	
	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public Task updateTask(@RequestBody Task task) {
		
		Optional<Task> taskOptional = taskRepository.findById(task.getId());
		taskRepository.save(taskOptional);
		if (!taskOptional.isPresent())
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"unable to update task");
		return taskOptional.get();
	} 
	
	@DeleteMapping(value = "/{taskId}")
	public void deleteTask(@PathVariable final Long taskId) {
		Optional<Task> taskOptional = taskRepository.findById(taskId);
		taskRepository.delete(taskOptional);
		if (!taskOptional.isPresent())
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"unable to delete task");
	}
	
}
