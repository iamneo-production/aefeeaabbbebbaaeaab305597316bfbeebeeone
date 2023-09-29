package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Student;
import com.example.springapp.repository.StudentRepo;

@Service
public class ApiService {
   
    @Autowired
    public StudentRepo studentRepo;
 

    public boolean addNew(Student student){
        return studentRepo.save(student) !=null?true:false;
    }
}
