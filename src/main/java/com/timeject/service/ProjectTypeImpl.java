package com.timeject.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.timeject.model.ProjectType;
import com.timeject.repository.ProjectTypeRepository;

@Service("projectTypeService")
public class ProjectTypeImpl implements ProjectTypeService {

	private ProjectTypeRepository projectTypeRepository;

	@Override
	public Iterable<ProjectType> findAll() {
		return projectTypeRepository.findAll();
	}

	@Inject
	public ProjectTypeImpl(ProjectTypeRepository projectTypeRepository) {
		this.projectTypeRepository = projectTypeRepository;
	}

}
