package com.snn.university.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @GetMapping("/api/department")
    public String getDepartment(){


        return "Hello my department";
    }
}
