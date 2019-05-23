package com.timeject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.timeject.model.ProjectStatus;

@Repository
public interface ProjectStatusRepository extends CrudRepository<ProjectStatus, Long> {

}
