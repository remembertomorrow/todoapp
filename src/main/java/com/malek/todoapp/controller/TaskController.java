package com.malek.todoapp.controller;

import com.malek.todoapp.controller.dtos.TaskDto;
import com.malek.todoapp.model.Status;
import com.malek.todoapp.model.StatusEnum;
import com.malek.todoapp.model.Task;
import com.malek.todoapp.service.StatusService;
import com.malek.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.malek.todoapp.util.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private StatusService statusService;

    @RequestMapping("/tasks")
    public List<TaskDto> getAllTasks(){
        List<TaskDto> taskDtos = new ArrayList<TaskDto>();

        taskService.getAllTasks().forEach(t -> {
            TaskDto taskDto = TaskUtils.getTaskDto(t);
            taskDtos.add(taskDto);
        });
        return taskDtos;
    }

    @RequestMapping("/tasks/{id}")
    public TaskDto getTask(@PathVariable Long id){
        Task t = taskService.getTask(id);
        return TaskUtils.getTaskDto(t);
    }

    @RequestMapping(method= RequestMethod.POST, value="/tasks")
    public void addTask(@RequestBody TaskDto taskDto){
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
        status.setTask(task);
        statusService.addStatus(status);

        taskService.addTask(task);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/tasks/{id}")
    public void updateTask(@RequestBody TaskDto taskDto, @PathVariable Long id){
        Task task = taskService.getTask(id);
        if(!task.getTitle().equals(taskDto.getTitle())) {
            task.setTitle(taskDto.getTitle());
        }
        if(!task.getDescription().equals(taskDto.getDescription())){
            task.setDescription(taskDto.getDescription());
        }
        if(taskDto.getDueDate() != null && !task.getDueDate().equals(taskDto.getDueDate())){
            task.setDueDate(taskDto.getDueDate());
        }
        task.setModifyDate(LocalDateTime.now());

        Status oldStatus = TaskUtils.getTasksCurrentStatus(task);
        if(!oldStatus.equals(taskDto.getStatus())){
            oldStatus.setFinishDate(LocalDateTime.now());
            statusService.updateStatus(oldStatus.getStatusId(), oldStatus);
            Status status = taskDto.getStatus();
            status.setTask(task);
            statusService.addStatus(status);
        }
    }
}
