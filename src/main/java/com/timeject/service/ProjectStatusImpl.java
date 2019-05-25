package com.timeject.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.timeject.model.ProjectStatus;
import com.timeject.repository.ProjectStatusRepository;

@Service("projectStatusService")
public class ProjectStatusImpl implements ProjectStatusService {

	private ProjectStatusRepository projectStatusRepository;

	@Override
	public Iterable<ProjectStatus> findAll() {
		return projectStatusRepository.findAll();
	}

	@Inject
	public ProjectStatusImpl(ProjectStatusRepository projectStatusRepository) {
		this.projectStatusRepository = projectStatusRepository;
	}

}
