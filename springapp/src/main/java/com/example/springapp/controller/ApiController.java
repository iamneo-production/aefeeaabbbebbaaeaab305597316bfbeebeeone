package com.example.springapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Student;
import com.example.springapp.service.ApiService;

@RestController
public class ApiController {
    @Autowired
    public ApiService apiService;

    

    @PostMapping("/api/student")
    public boolean addNewData(@RequestBody Student student){
        return apiService.addNew(student);
    }
}