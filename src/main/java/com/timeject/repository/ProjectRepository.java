package com.timeject.repository;

import com.timeject.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long>{
	Project findByName(String name);
}
