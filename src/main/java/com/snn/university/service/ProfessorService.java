package com.snn.university.service;

import com.snn.university.dto.ProfessorDTO;
import com.snn.university.exception.MyEntityNotFoundException;
import com.snn.university.model.Department;
import com.snn.university.model.Professor;
import com.snn.university.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ProfessorService {

    public static final String PROFESSOR = "professor";

    @Autowired
    private ProfessorRepository repository;

    public List<ProfessorDTO> getAll() {
        List<Professor> list = repository.findAll();
        List<ProfessorDTO> dtoList = list.stream().
                map(p -> new ProfessorDTO(p.getId(),
                        p.getName(),
                        p.getDepartment().getId())).
                collect(toList());
        return dtoList;
    }

    public ProfessorDTO getById(Integer id) {
        Professor entity = findById(id);
        ProfessorDTO dto = new ProfessorDTO(entity.getId(), entity.getName(), entity.getDepartment().getId());
        return dto;
    }

    public Professor findById(Integer id) {
        Professor entity = repository.findById(id).orElseThrow(() -> new MyEntityNotFoundException(id, PROFESSOR));
        return entity;
    }

    public Integer create(ProfessorDTO dto) {
        Professor entity = new Professor(
                dto.getId(),
                dto.getName(),
                new Department(dto.getDepartmentId(), null));

        repository.save(entity);
        return entity.getId();
    }

    public Integer update(Integer id, ProfessorDTO dto) {
        Professor entity = findById(id);
        entity.setName(dto.getName());
        entity.setDepartment(new Department(dto.getDepartmentId(), null));
        repository.save(entity);
        return entity.getId();
    }

    public void delete(Integer id) {
        Professor professor = findById(id);
        repository.deleteById(id);
    }
}
