package com.snn.university.service;

import com.snn.university.dto.DepartmentDTO.DepartmentDTO;
import com.snn.university.exception.MyEntityNotFoundException;
import com.snn.university.model.Department;
import com.snn.university.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DepartmentService {

    public static final String DEPARTMENT = "department";
    @Autowired
    private DepartmentRepository departmentRepo;

    public List<DepartmentDTO> getAll() {
        List<Department> list = departmentRepo.findAll();
        List<DepartmentDTO> dtoList = list.stream().
                map(p -> new DepartmentDTO(p.getId(), p.getName())).
                collect(toList());
        return dtoList;
    }

    public DepartmentDTO getById(Integer id) {
        Department dept = findById(id);
        DepartmentDTO deptDTO = new DepartmentDTO(dept.getId(), dept.getName());
        return deptDTO;
    }

    public Department findById(Integer id) {
        Department dept = departmentRepo.findById(id).orElseThrow(() -> new MyEntityNotFoundException(id, DEPARTMENT));
        return dept;
    }

    public Integer create(DepartmentDTO dto) {
        Department department = new Department(dto.getId(), dto.getName());
        departmentRepo.save(department);
        return department.getId();
    }

    public Integer update(Integer id, DepartmentDTO dto) {
        Department dept = findById(id);
        dept.setName(dto.getName());
        departmentRepo.save(dept);
        return dept.getId();
    }

    public void delete(Integer id) {
        Department dept = findById(id);
        departmentRepo.deleteById(dept.getId());
    }

}
