package com.timeject.service;

import com.timeject.exception.NotFoundException;
import com.timeject.model.Project;

import java.util.Optional;

public interface ProjectService {
    void update(Project project) throws NotFoundException;
    Project findById(Long id) throws NotFoundException;
    Optional<Project> findByName(String name);
    Iterable<Project> findAll();
    void deleteById(Long id);

}
