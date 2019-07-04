package com.malek.todoapp;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.malek.todoapp.controller.TaskController;
import com.malek.todoapp.model.PriorityEnum;
import com.malek.todoapp.model.Task;
import com.malek.todoapp.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskServiceTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getProperTaskTitleWithId() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        Task mockTask = new Task();
        mockTask.setTaskId(7l);
        LocalDateTime mockDate = LocalDateTime.now();
        mockTask.setTitle("Create task managing app for Yordex");
        mockTask.setDescription("The goal of this task is to create a simple TODO application, which helps with managing tasks. It is a part of recruitment process at Yordex");
        mockTask.setDueDate(LocalDateTime.parse("2019-07-07 00:00", formatter));
        mockTask.setCreateDate(LocalDateTime.parse("2018-10-29 00:00", formatter));
        mockTask.setPriority(PriorityEnum.HIGHEST);
        assertThat(this.restTemplate.getForObject("http://localhost:" + 8080 + "/" + "tasks",
                Task.class)).isEqualTo(mockTask);
    }
}