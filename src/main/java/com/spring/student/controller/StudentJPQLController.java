package com.spring.student.controller;

import com.spring.student.model.groups;
import com.spring.student.model.students;
import com.spring.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentJPQLController {

    @Autowired
    private StudentRepository repository;

    @GetMapping("/studentsjpql")
    public List<students> getStudent(){
        return repository.findAllstudents();
    }

    @GetMapping("/studentsByNamejpql/{name}")
    public List<students> findByName(@PathVariable String name){
        return repository.findstudentsByName(name);
    }

    @GetMapping("/studentsByIdljpql/{idStudent}")
    public Optional<students> getById(@PathVariable long idStudent){ return repository.findStudentsById(idStudent);}

    @DeleteMapping("/deletestudentjpql/{idStudent}")
    @Transactional
    public void deletebyid(@PathVariable(value = "idStudent") long idStudent){
        repository.deleteStudentById(idStudent);
    }

}

