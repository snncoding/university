package com.snn.university.controller;

import com.snn.university.dto.ProfessorDTO;
import com.snn.university.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    @GetMapping
    public List<ProfessorDTO> getAll(){
        List<ProfessorDTO> dtoList = service.getAll();

        return dtoList;
    }

    @GetMapping("/{id}")
    public ProfessorDTO getById(@PathVariable Integer id){
        ProfessorDTO dto = service.getById(id);
        return dto;
    }

    @PostMapping
    public Integer create(@RequestBody ProfessorDTO profDTO){
        return service.create(profDTO);
    }

    @PutMapping("/{id}")
    public Integer update(@PathVariable Integer id, @RequestBody ProfessorDTO profDTO){
        return service.update(id, profDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
