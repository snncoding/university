package com.snn.university.controller;

import com.snn.university.dto.ScheduleDTO;
import com.snn.university.model.Course;
import com.snn.university.model.Professor;
import com.snn.university.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService service;

    @GetMapping
    public List<ScheduleDTO> getAll(){
        List<ScheduleDTO> dtoList = service.getAll();

        return dtoList;
    }

    @GetMapping("/{id}")
    public ScheduleDTO getById(@PathVariable Integer id){
        ScheduleDTO dto = service.getById(id);
        return dto;
    }

    @PostMapping
    public Integer create(@RequestBody ScheduleDTO dto){
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Integer update(@PathVariable Integer id, @RequestBody ScheduleDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

}
