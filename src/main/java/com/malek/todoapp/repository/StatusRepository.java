package com.malek.todoapp.repository;

import com.malek.todoapp.model.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Long> {
}
