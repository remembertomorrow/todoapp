package com.malek.todoapp.util;

import com.malek.todoapp.controller.dtos.TaskDto;
import com.malek.todoapp.model.Status;
import com.malek.todoapp.model.Task;
import com.malek.todoapp.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class TaskUtils {

    @Autowired
    private static StatusService statusService;

    public static TaskDto getTaskDto(Task t){
        TaskDto taskDto = new TaskDto();

        taskDto.setTitle(t.getTitle());
        taskDto.setDescription(t.getDescription());
        if(t.getDueDate() != null) {
            taskDto.setDueDate(t.getDueDate());
        }
        taskDto.setCreateDate(t.getCreateDate());
        if(t.getModifyDate() != null){
            taskDto.setModifyDate(t.getModifyDate());
        }
        taskDto.setStatus(getTasksCurrentStatus(t));
        return taskDto;
    }

    public static Status getTasksCurrentStatus(Task t){
        List<Status> allStatuses = statusService.getAllStatuses().stream()
                .filter(s -> (s.getTask().getTaskId() == t.getTaskId()) && s.getFinishDate() == null)
                .collect(Collectors.toList());
        Status currentStatus = allStatuses.get(0);
        return currentStatus;
    }
}
