package com.malek.todoapp.repository;

import com.malek.todoapp.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
