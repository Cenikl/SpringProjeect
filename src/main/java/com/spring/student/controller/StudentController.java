package com.spring.student.controller;

import com.spring.student.model.groups;
import com.spring.student.model.students;
import com.spring.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @GetMapping("/students")
    public List<students> getStudent(){
        return repository.findAll();
    }

    @GetMapping("/studentsByName/{name}")
    public List<students> findByName(@PathVariable String name){
        return repository.findByNameLike(name);
    }

    @GetMapping("/studentsById/{idStudent}")
    public Optional<students> getById(@PathVariable long idStudent){
        return repository.findByIdStudent(idStudent);
    }

    @DeleteMapping("/deletestudent/{idStudent}")
    @Transactional
    public void deletebyid(@PathVariable(value = "idStudent") long idStudent){
        repository.deleteByIdStudent(idStudent);
    }


    @PostMapping("/studentssave/")
    public students save(students s){
        groups test = new groups("G2","tech", LocalDate.now());
        return repository.save(new students(5,"chara",test));
    }




    /*
    @GetMapping("/students/{id}")
    public String getStudentById (@PathVariable(required = true) String id){
        return "Hello";
    }

    @PostMapping("/students")
    public String postStudents (@RequestBody(required = false) byte[] something){
        return "Hello";
    }

    @PatchMapping("/students/{id}")
    public String patchStudents (@PathVariable(required = true) String id, @RequestBody(required = false) students test){
        return "Hello";
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudentsById (@PathVariable(required = true) String id){
        return "Hello";
    }

    @PutMapping("/students/{id}")
    public String putStudentsById (@PathVariable(required = true) String id,@RequestBody(required = false) students student){
        return "Hello";
    }
     */
}

