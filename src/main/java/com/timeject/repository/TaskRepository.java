package com.timeject.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.timeject.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{

	void save(Optional<Task> taskOptional);

	void delete(Optional<Task> taskOptional);

}
