package com.snn.university.service;

import com.snn.university.dto.CourseDTO;
import com.snn.university.exception.MyEntityNotFoundException;
import com.snn.university.model.Course;
import com.snn.university.model.Department;
import com.snn.university.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CourseService {
    public static final String COURSE = "course";

    @Autowired
    private CourseRepository repository;

    public List<CourseDTO> getAll() {
        List<Course> list = repository.findAll();
        List<CourseDTO> dtoList = list.stream().
                map(p -> new CourseDTO(p.getId(),
                        p.getName(),
                        p.getDepartment().getId(),
                        p.getCredits())).
                collect(toList());
        return dtoList;
    }

    public CourseDTO getById(Integer id) {
        Course entity = findById(id);
        CourseDTO dto = new CourseDTO(
                entity.getId(),
                entity.getName(),
                entity.getDepartment().getId(),
                entity.getCredits()
        );
        return dto;
    }

    public Course findById(Integer id) {
        Course entity = repository.findById(id).orElseThrow(() -> new MyEntityNotFoundException(id, COURSE));
        return entity;
    }

    public Integer create(CourseDTO dto) {
        Course entity = new Course(
                dto.getId(),
                dto.getName(),
                new Department(dto.getDepartmentId(), null),
                dto.getCredits());

        repository.save(entity);
        return entity.getId();
    }

    public Integer update(Integer id, CourseDTO dto) {
        Course entity = findById(id);
        entity.setName(dto.getName());
        entity.setDepartment(new Department(dto.getDepartmentId(), null));
        repository.save(entity);
        return entity.getId();
    }

    public void delete(Integer id) {
        Course professor = findById(id);
        repository.deleteById(id);
    }
}
