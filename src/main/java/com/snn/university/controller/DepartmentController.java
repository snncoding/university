package com.snn.university.controller;

import com.snn.university.dto.DepartmentDTO.DepartmentDTO;
import com.snn.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping
    public List<DepartmentDTO> getAll() {
        List<DepartmentDTO> dtoList = service.getAll();

        return dtoList;
    }

    @GetMapping("/{id}")
    public DepartmentDTO getById(@PathVariable Integer id) {
        DepartmentDTO deptDTO = service.getById(id);
        return deptDTO;
    }

    @PostMapping
    public Integer create(@RequestBody DepartmentDTO departmentDTO) {
        Integer id = service.create(departmentDTO);
        return id;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody DepartmentDTO dto) {

        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
