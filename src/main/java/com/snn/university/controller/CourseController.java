package com.snn.university.controller;

import com.snn.university.dto.CourseDTO;
import com.snn.university.dto.ProfessorDTO;
import com.snn.university.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService service;

    @GetMapping
    public List<CourseDTO> getAll(){
        List<CourseDTO> dtoList = service.getAll();

        return dtoList;
    }

    @GetMapping("/{id}")
    public CourseDTO getById(@PathVariable Integer id){
        CourseDTO dto = service.getById(id);
        return dto;
    }

    @PostMapping
    public Integer create(@RequestBody CourseDTO dto){
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Integer update(@PathVariable Integer id, @RequestBody CourseDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
