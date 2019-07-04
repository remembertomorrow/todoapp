package com.malek.todoapp;

import com.malek.todoapp.controller.TaskController;
import com.malek.todoapp.model.PriorityEnum;
import com.malek.todoapp.model.Task;
import com.malek.todoapp.service.TaskService;
import javafx.application.Application;
import org.apache.tomcat.jni.Local;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TaskController.class, secure = false)
public class TodoappApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    private TaskService taskService;

//    @Test
//    public void getTasksTest() throws Exception{
//        List<Task> mockTaskList = new ArrayList<>();
//        Task mockTask = new Task();
//        mockTask.setTaskId(7l);
//        LocalDateTime mockDate = LocalDateTime.now();
//        mockTask.setTitle("testTask");
//        mockTask.setDescription("testTask");
//        mockTask.setDueDate(mockDate);
//        mockTask.setCreateDate(mockDate);
//        mockTask.setPriority(PriorityEnum.HIGH);
//        mockTaskList.add(mockTask);
//
////        String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
//
//        Mockito.when(
//                taskService.getAllTasks()).thenReturn(mockTaskList);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//                "/tasks").accept(
//                MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        System.out.println(result.getResponse());
//        String expected = "{title:testTask}";
//
//        // {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}
//
//        JSONAssert.assertEquals(expected, result.getResponse()
//                .getContentAsString(), false);
//    }

}
