package com.malek.todoapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.malek.todoapp.controller.TaskController;
import com.malek.todoapp.dto.TaskDto;
import com.malek.todoapp.model.Task;
import com.malek.todoapp.repository.StatusRepository;
import com.malek.todoapp.repository.TaskRepository;
import com.malek.todoapp.service.StatusService;
import com.malek.todoapp.service.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
@Component
public class Test2 {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private TaskService taskService;

    @Mock
    private StatusService statusService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void it_should_return_task() throws Exception{
        Task task = new Task();
        task.setTaskId(1L);
        when(taskService.getTask(1L)).thenReturn(task);

        TaskDto t = taskController.getTask(1L);
        assertEquals(1L, t.getTaskId().longValue());
    }
}
