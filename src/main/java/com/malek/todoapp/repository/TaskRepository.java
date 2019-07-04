package com.malek.todoapp.repository;

import com.malek.todoapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
