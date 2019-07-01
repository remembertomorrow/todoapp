package com.malek.todoapp.controller.dtos;

import com.malek.todoapp.model.Status;

import java.time.LocalDateTime;

public class TaskDto {

    private Long taskId;

    private String title;

    private String description;

    private LocalDateTime dueDate;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private Status status;
}
