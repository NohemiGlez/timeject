package com.timeject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.timeject.model.ProjectType;

@Repository
public interface ProjectTypeRepository extends CrudRepository<ProjectType, Long>{
	
}
