package com.malek.todoapp.service;

import com.malek.todoapp.controller.TaskController;
import com.malek.todoapp.dto.TaskDto;
import com.malek.todoapp.model.*;
import com.malek.todoapp.repository.TaskRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(TaskController.class)
@Component
public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private StatusService statusService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void it_should_return_taskDto_with_proper_fields() throws Exception{

        Task task = initTestTask();
        when(taskRepository.getOne(1L)).thenReturn(task);
        TaskDto t = taskService.getTask(1L);

        assertEquals(t.getTaskId().longValue(), 1L);
        assertEquals(t.getTitle(), "Create task managing app for Yordex");
        assertEquals(t.getDescription(), "The goal of this task is to create a simple TODO application, which helps with managing tasks. It is a part of recruitment process at Yordex");
        assertEquals(t.getDueDate(), LocalDateTime.parse("2019-07-07T00:00"));
        assertEquals(t.getCreateDate(), LocalDateTime.parse("2018-10-29T00:00"));
        assertEquals(t.getModifyDate(), null);
        assertEquals(t.getPriority(), PriorityEnum.HIGHEST);

    }

    @Test
    public void it_should_return_list_of_tasks() throws Exception{
        List<Task> listOfTestTasks = new ArrayList<>();
        listOfTestTasks.add(initTestTask());
        listOfTestTasks.add(initTestTask());

        when(taskRepository.findAll()).thenReturn(listOfTestTasks);
        assert taskService.getAllTasks().size() == 2;
    }


    private Task initTestTask(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Task task = new Task();
        task.setTaskId(1L);
        task.setTitle("Create task managing app for Yordex");
        task.setDescription("The goal of this task is to create a simple TODO application, which helps with managing tasks. It is a part of recruitment process at Yordex");
        task.setDueDate(LocalDateTime.parse("2019-07-07 00:00:00", formatter));
        task.setCreateDate(LocalDateTime.parse("2018-10-29 00:00:00", formatter));
        task.setModifyDate(null);
        task.setPriority(PriorityEnum.HIGHEST);

        return task;
    }


}
