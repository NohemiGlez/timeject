package com.timeject.service;

import java.util.Optional;

import com.timeject.exception.NotFoundException;
import com.timeject.model.Project;

public interface ProjectService {
    void update(Project project) throws NotFoundException;
    Project findById(Long id) throws NotFoundException;
    Optional<Project> findByName(String name);
    Iterable<Project> findAll();
    void save(Project project);
	void deleteById(Project project);
}
