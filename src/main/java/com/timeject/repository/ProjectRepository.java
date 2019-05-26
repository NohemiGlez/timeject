package com.timeject.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.timeject.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long>{
	Optional<Project> findByName(String name);
	Iterable<Project> findAllByOrderByIdDesc();
}
