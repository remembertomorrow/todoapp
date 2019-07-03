package com.malek.todoapp.controller.dtos;

import com.malek.todoapp.model.Status;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class TaskDto {

    private Long statusId;

    private String title;

    private String description;

    private LocalDateTime dueDate;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private Status status;
}
