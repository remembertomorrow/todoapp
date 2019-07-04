package com.malek.todoapp.repository;

import com.malek.todoapp.model.Status;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface StatusRepository extends CrudRepository<Status, Long> {

//    public Status findByTaskIdAndFinishDate(Long taskId, LocalDateTime date);
}
