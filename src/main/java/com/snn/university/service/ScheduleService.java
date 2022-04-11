package com.snn.university.service;

import com.snn.university.dto.ScheduleDTO;
import com.snn.university.dto.SearchDTO;
import com.snn.university.exception.MyEntityNotFoundException;
import com.snn.university.model.Course;
import com.snn.university.model.Professor;
import com.snn.university.model.Schedule;
import com.snn.university.model.Search;
import com.snn.university.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
public class ScheduleService {
    public static final String SCHEDULE = "schedule";

    @Autowired
    private ScheduleRepository repository;

    public List<ScheduleDTO> getAll() {
        List<Schedule> list = repository.findAll();
        List<ScheduleDTO> dtoList = list.stream().
                map(p -> new ScheduleDTO(
                        p.getId(),
                        p.getProfessor().getId(),
                        p.getCourse().getId(),
                        p.getSemester(),
                        p.getYear())).
                collect(toList());
        return dtoList;
    }

    public ScheduleDTO getById(Integer id) {
        Schedule entity = findById(id);
        ScheduleDTO dto = new ScheduleDTO(
                entity.getId(),
                entity.getProfessor().getId(),
                entity.getCourse().getId(),
                entity.getSemester(),
                entity.getYear()
        );
        return dto;
    }

    public Schedule findById(Integer id) {
        Schedule entity = repository.findById(id).orElseThrow(() -> new MyEntityNotFoundException(id, SCHEDULE));
        return entity;
    }

    public Integer create(ScheduleDTO dto) {
        Schedule entity = new Schedule(
                dto.getId(),
                new Professor(dto.getProfessorId(), null, null),
                new Course(dto.getCourseId(), null, null, null),
                dto.getSemester(),
                dto.getYear()
        );

        entity = repository.save(entity);
        return entity.getId();
    }

    public Integer update(Integer id, ScheduleDTO dto) {
        Schedule entity = findById(id);
        entity.setProfessor(new Professor(dto.getProfessorId()));
        entity.setCourse(new Course(dto.getCourseId()));
        entity.setSemester(dto.getSemester());
        entity.setYear(dto.getYear());
        repository.save(entity);
        return entity.getId();
    }

    public void delete(Integer id) {
        Schedule professor = findById(id);
        repository.deleteById(id);
    }

    public Set<SearchDTO> search(){
        List<Search> list = repository.fetchProfCourseDataLeftJoin();
//        return list.parallelStream().
//                collect(groupingBy(Search::getProfessorName, mapping(Search::getCourseName, toList())));
        Map<String, List<String>> map = list.parallelStream().
                collect(
                        groupingBy(
                                Search::getProfessorName,
                                mapping(Search::getCourseName, toList()))
                );
        return map.keySet().stream().map(p-> new SearchDTO(p, map.get(p))).collect(toSet());
    }
}
