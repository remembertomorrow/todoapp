package com.malek.todoapp.service;

import com.malek.todoapp.model.Status;
import com.malek.todoapp.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAllStatuses(){
        List<Status> list = new ArrayList<>();
        statusRepository.findAll().forEach(c -> list.add(c));
        return list;
    }

    public Status getStatus(long id){
        return statusRepository.findById(id).get();
    }

    public void addStatus(Status status){
        statusRepository.save(status);
    }

    public void updateStatus(Long id, Status status){
        statusRepository.save(status);
    }
    public void deleteStatus(Long id){
        statusRepository.deleteById(id);
    }
}
