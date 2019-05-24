package com.timeject.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.timeject.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long>{
	
	Project findByName(String name);
	
	Optional<Project> findByOptionalName(String name);

	void delete(Optional<Project> projectOptional);

	void save(Optional<Project> projectOptional);
}
