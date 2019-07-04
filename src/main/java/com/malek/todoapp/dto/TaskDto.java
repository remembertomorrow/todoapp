package com.malek.todoapp.dto;

import com.malek.todoapp.model.PriorityEnum;
import com.malek.todoapp.model.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDto {

    private Long taskId;

    private String title;

    private String description;

    private LocalDateTime dueDate;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private PriorityEnum priority;

    private Status status;
}
