package com.malek.todoapp.controller;

import com.malek.todoapp.controller.dtos.TaskDto;
import com.malek.todoapp.model.Status;
import com.malek.todoapp.model.StatusEnum;
import com.malek.todoapp.model.Task;
import com.malek.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/tasks")
    public List<TaskDto> getAllTasks(){
        List<TaskDto> taskDtos = new ArrayList<TaskDto>();

        taskService.getAllTasks().forEach(t -> {
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
            taskDto.setStatus(t.getStatus());

            taskDtos.add(taskDto);
        });
        return taskDtos;
    }

    @RequestMapping(method= RequestMethod.POST, value="/tasks")
    public void addTask(TaskDto taskDto){
        Task task = new Task();

        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        if(taskDto.getDueDate() != null) {
            task.setDueDate(taskDto.getDueDate());
        }
        task.setCreateDate(LocalDateTime.now());
        Status status = new Status();
        status.setStartDate(LocalDateTime.now());
        status.setStatus(StatusEnum.OPEN);
        task.setStatus(status);
    }
}
