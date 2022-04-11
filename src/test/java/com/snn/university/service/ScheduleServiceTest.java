package com.snn.university.service;

import com.snn.university.dto.CourseDTO;
import com.snn.university.dto.ScheduleDTO;
import com.snn.university.dto.SearchDTO;
import com.snn.university.exception.MyEntityNotFoundException;
import com.snn.university.model.*;
import com.snn.university.repository.ScheduleRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ScheduleServiceTest {

    @Mock
    private ScheduleRepository repository;

    @InjectMocks
    private ScheduleService service;

    private List<Schedule> list;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        list = Lists.list(
                new Schedule(1, new Professor(1), new Course(2), 1,2009),
                new Schedule(2, new Professor(2), new Course(1), 2,2010),
                new Schedule(3, new Professor(1), new Course(2), 1,2009)
        );
    }

    @Test
    void getAll() {
        when(repository.findAll()).thenReturn(list);
        List<ScheduleDTO> dto = service.getAll();
        assertNotNull(dto);
        assertTrue(dto.size() == 3);
        assertEquals(dto.get(0).getId(), 1);
    }

    @Test
    void findById() {
        when(repository.findById(1)).thenReturn(Optional.of(list.get(0)));
        Schedule entity = service.findById(1);
        assertNotNull(entity);
        assertEquals(entity.getId(), 1);

        when(repository.findById(4)).thenThrow(new MyEntityNotFoundException(4, service.SCHEDULE));
        assertThrows(MyEntityNotFoundException.class, () -> service.findById(4));
    }

    @Test
    void getById() {
        when(repository.findById(1)).thenReturn(Optional.of(list.get(0)));
        ScheduleDTO dto = service.getById(1);
        assertNotNull(dto);
        assertEquals(dto.getId(), 1);
    }


    @Test
    void create() {
        when(repository.save(any())).thenReturn(list.get(0));
        Integer id = service.create(
                new ScheduleDTO(
                        list.get(0).getId(),
                        list.get(0).getProfessor().getId(),
                        list.get(0).getCourse().getId(),
                        list.get(0).getSemester(),
                        list.get(0).getYear()
                )
        );
        assertEquals(id, 1);
    }

    @Test
    void update() {
        when(repository.findById(1)).thenReturn(Optional.of(list.get(0)));
        when(repository.save(any())).thenReturn(list.get(0));
        Integer id = service.update(1,
                new ScheduleDTO(
                        list.get(0).getId(),
                        list.get(0).getProfessor().getId(),
                        list.get(0).getCourse().getId(),
                        list.get(0).getSemester(),
                        list.get(0).getYear()
                )
        );
        assertEquals(id, 1);
    }

    @Test
    void delete() {
        when(repository.findById(1)).thenReturn(Optional.of(list.get(0)));
        service.delete(1);
        verify(repository).deleteById(any());
    }

    @Test
    void search(){
        List<Search> list = Lists.list(
                new Search("Prof1", "Course1"),
                new Search("Prof1", "Course2"),
                new Search("Prof2", "Course1"),
                new Search("Prof3", "Course1")
                );
        when(repository.fetchProfCourseDataLeftJoin()).thenReturn(list);
        Set<SearchDTO> dtos = service.search();
        assertEquals(dtos.size(), 3);
    }
}