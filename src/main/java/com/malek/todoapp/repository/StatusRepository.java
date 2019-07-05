package com.malek.todoapp.repository;

import com.malek.todoapp.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {

//    public Status findByTaskIdAndFinishDate(Long taskId, LocalDateTime date);
}
