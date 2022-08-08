package com.spring.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {
    @GetMapping("/groups")
    public String getGroups (){
        return "Hello";
    }
}
