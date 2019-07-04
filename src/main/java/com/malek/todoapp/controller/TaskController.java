package com.malek.todoapp.controller;

import com.malek.todoapp.dto.TaskDto;
import com.malek.todoapp.service.StatusService;
import com.malek.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private StatusService statusService;

    @RequestMapping("/tasks")
    public List<TaskDto> getAllTasks(){
        return taskService.getAllTasks();
    }

    @RequestMapping("/tasks/{id}")
    public TaskDto getTask(@PathVariable Long id){
        return taskService.getTask(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/tasks")
    public void addTask(@RequestBody TaskDto taskDto){
        taskService.addTask(taskDto);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/tasks/{id}")
    public void updateTask(@RequestBody TaskDto taskDto, @PathVariable Long id){
        taskService.updateTask(taskDto.getTaskId(), taskDto);
    }

}
