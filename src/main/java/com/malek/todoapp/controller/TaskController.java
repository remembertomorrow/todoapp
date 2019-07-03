package com.malek.todoapp.controller;

import com.malek.todoapp.controller.dtos.TaskDto;
import com.malek.todoapp.controller.util.TaskUtils;
import com.malek.todoapp.model.Status;
import com.malek.todoapp.model.StatusEnum;
import com.malek.todoapp.model.Task;
import com.malek.todoapp.service.StatusService;
import com.malek.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            TaskDto taskDto = getTaskDto(t);
            taskDtos.add(taskDto);
        });
        return taskDtos;
    }

    @RequestMapping("/tasks/{id}")
    public TaskDto getTask(@PathVariable Long id){
        Task t = taskService.getTask(id);
        return getTaskDto(t);
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
        task.setPriority(taskDto.getPriority());
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
        if(taskDto.getDueDate() != null && !task.getDueDate().equals(taskDto.getDueDate())) {
            task.setPriority(taskDto.getPriority());
        }
        Status oldStatus = getTasksCurrentStatus(task);
        if(!oldStatus.equals(taskDto.getStatus())){
            oldStatus.setFinishDate(LocalDateTime.now());
            statusService.updateStatus(oldStatus.getStatusId(), oldStatus);
            Status status = taskDto.getStatus();
            status.setTask(task);
            statusService.addStatus(status);
        }
    }

    public Status getTasksCurrentStatus(Task t){
        List<Status> allStatuses = statusService.getAllStatuses().stream()
                .filter(s -> (s.getTask().getTaskId() == t.getTaskId()) && s.getFinishDate() == null)
                .collect(Collectors.toList());
        if(allStatuses.isEmpty()){
            return null;
        }else{
            Status currentStatus = allStatuses.get(0);
            return currentStatus;
        }
    }

    public TaskDto getTaskDto(Task t){
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
        taskDto.setPriority(t.getPriority());
        taskDto.setStatus(getTasksCurrentStatus(t));
        return taskDto;
    }
}
