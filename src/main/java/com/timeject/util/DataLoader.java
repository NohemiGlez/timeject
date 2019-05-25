package com.timeject.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

import com.timeject.model.Project;
import com.timeject.model.ProjectStatus;
import com.timeject.model.ProjectType;
import com.timeject.model.Task;
import com.timeject.repository.ProjectRepository;
import com.timeject.repository.ProjectStatusRepository;
import com.timeject.repository.TaskRepository;

@Component
public class DataLoader implements ApplicationRunner {
	private ProjectRepository projectRepository;
	private TaskRepository taskRepository;
	private static final String[] PROJECT_TYPES = { "A", "B", "C" };
	@Inject
	public DataLoader(ProjectRepository projectRepository, TaskRepository taskRepository) {
		this.projectRepository = projectRepository;
		this.taskRepository = taskRepository;
	}

	public void run(ApplicationArguments args) {
		saveProjects();
	}

	private void saveProjects() {
		for (int i = 0; i < 10; i++) {
			Project project = new Project();
			project.setDescription("my description no" + i);
			project.setName("Project No. " + i);
			project.setStatus(getStatus());
			project.setType(getType(PROJECT_TYPES[i % 3]));
			project.setTask(getTasks());
			projectRepository.save(project);
		}
	}

	private ProjectType getType(String type) {
		ProjectType projectType = new ProjectType();
		projectType.setType(type);
		return projectType;
	}

	private ProjectStatus getStatus() {
		ProjectStatus status = new ProjectStatus();
		Calendar calendar = Calendar.getInstance();
		status.setStart(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		calendar.add(Calendar.MONTH, 1);
		status.setEnd(new Timestamp(calendar.getTimeInMillis()));
		return status;
	}

	private Collection<Task> getTasks() {
		Collection<Task> tasks = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Task task = new Task();
			task.setDescription("task no " + i);
			task.setStartDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));

		}
		taskRepository.saveAll(tasks);
		return tasks;
	}

}