package com.timeject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.timeject.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{

}
