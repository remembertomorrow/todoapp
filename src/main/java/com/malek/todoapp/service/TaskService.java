package com.malek.todoapp.service;

import com.malek.todoapp.model.Task;
import com.malek.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        List<Task> list = new ArrayList<>();
        taskRepository.findAll().forEach(c -> list.add(c));
        return list;
    }

    public Task getTask(long id){
        return taskRepository.findById(id).get();
    }

    public void addTask(Task task){
        taskRepository.save(task);
    }

    public void updateTask(Long id, Task task){
        taskRepository.save(task);
    }
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
