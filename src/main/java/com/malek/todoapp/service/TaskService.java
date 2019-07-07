package com.malek.todoapp.service;

import com.malek.todoapp.dto.TaskDto;
import com.malek.todoapp.model.Status;
import com.malek.todoapp.model.StatusEnum;
import com.malek.todoapp.model.Task;
import com.malek.todoapp.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private StatusService statusService;

    public List<TaskDto> getAllTasks(){

        log.info("invoke select * from tasks");

        List<TaskDto> list = new ArrayList<>();
        taskRepository.findAll().forEach(t -> {
            list.add(getTaskDto(t));
        });

        return list;
    }

    public TaskDto getTask(long id){
        return getTaskDto(taskRepository.getOne(id));
    }

    public void addTask(TaskDto taskDto){

        log.info("invoke insert into tasks title = {}", taskDto.getTitle());

        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        if(taskDto.getDueDate() != null) {
            task.setDueDate(taskDto.getDueDate());
        }
        task.setCreateDate(LocalDateTime.now());
        task.setPriority(taskDto.getPriority());
        taskRepository.save(task);

        Status status = new Status();
        status.setStartDate(LocalDateTime.now());
        status.setStatus(StatusEnum.OPEN);
        status.setTask(task);
        statusService.addStatus(status);

    }

    public void updateTask(Long id, TaskDto taskDto){

        log.info("invoke update task with id = {}", id);

        Task task = taskRepository.findById(id).get();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());
        task.setModifyDate(LocalDateTime.now());
        task.setPriority(taskDto.getPriority());
        Status oldStatus = getTasksCurrentStatus(task);
        oldStatus.setFinishDate(LocalDateTime.now());
        statusService.updateStatus(oldStatus.getStatusId(), oldStatus);
        Status status = taskDto.getStatus();
        status.setTask(task);
        statusService.addStatus(status);

        taskRepository.save(task);
    }

    private Status getTasksCurrentStatus(Task t){
        List<Status> allStatuses = statusService.getAllStatuses().stream()
                .filter(s -> (s.getTask().getTaskId().equals(t.getTaskId())) && s.getFinishDate() == null)
                .collect(Collectors.toList());
        if(allStatuses.isEmpty()){
            return null;
        }else{
            return allStatuses.get(0);
        }
    }

    private TaskDto getTaskDto(Task t){
        TaskDto taskDto = new TaskDto();

        taskDto.setTaskId(t.getTaskId());
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
