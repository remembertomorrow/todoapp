package com.malek.todoapp.controller.util;
import com.malek.todoapp.controller.TaskController;
import org.springframework.beans.factory.annotation.Autowired;
import com.malek.todoapp.controller.dtos.TaskDto;
import com.malek.todoapp.model.Status;
import com.malek.todoapp.model.Task;
import com.malek.todoapp.service.StatusService;
import java.util.List;
import java.util.stream.Collectors;


public class TaskUtils {

    @Autowired
    private static TaskController taskController;


}
