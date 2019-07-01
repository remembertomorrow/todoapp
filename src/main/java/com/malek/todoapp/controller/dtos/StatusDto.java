package com.malek.todoapp.controller.dtos;

import com.malek.todoapp.model.StatusEnum;
import com.malek.todoapp.model.Task;
import java.time.LocalDateTime;
import java.util.Set;

public class StatusDto {

    private Long statusId;

    private StatusEnum status;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;

    private Set<Task> products;

}
