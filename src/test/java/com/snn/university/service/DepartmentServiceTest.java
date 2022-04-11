package com.snn.university.service;

import com.snn.university.dto.DepartmentDTO.DepartmentDTO;
import com.snn.university.dto.ProfessorDTO;
import com.snn.university.exception.MyEntityNotFoundException;
import com.snn.university.model.Department;
import com.snn.university.model.Professor;
import com.snn.university.repository.DepartmentRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DepartmentServiceTest {

    @Mock
    private DepartmentRepository repository;

    @InjectMocks
    private DepartmentService service;

    private List<Department> list;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        list = Lists.list(
                new Department(1, "Test1"),
                new Department(2, "Test2"),
                new Department(3, "Test3")
        );
    }

    @Test
    void getAll() {
        when(repository.findAll()).thenReturn(list);
        List<DepartmentDTO> dto = service.getAll();
        assertNotNull(dto);
        assertTrue(dto.size() == 3);
        assertEquals(dto.get(0).getId(), 1);
    }

    @Test
    void findById() {
        when(repository.findById(1)).thenReturn(Optional.of(list.get(0)));
        Department entity = service.findById(1);
        assertNotNull(entity);
        assertEquals(entity.getId(), 1);

        when(repository.findById(4)).thenThrow(new MyEntityNotFoundException(4, service.DEPARTMENT));
        assertThrows(MyEntityNotFoundException.class, () -> service.findById(4));
    }

    @Test
    void getById() {
        when(repository.findById(1)).thenReturn(Optional.of(list.get(0)));
        DepartmentDTO dto = service.getById(1);
        assertNotNull(dto);
        assertEquals(dto.getId(), 1);
    }

    @Test
    void create() {
        when(repository.save(any())).thenReturn(list.get(0));
        Integer id = service.create(
                new DepartmentDTO(
                        list.get(0).getId(),
                        list.get(0).getName()
                )
        );
        assertEquals(id, 1);
    }

    @Test
    void update() {
        when(repository.findById(1)).thenReturn(Optional.of(list.get(0)));
        when(repository.save(any())).thenReturn(list.get(0));
        Integer id = service.update(1,
                new DepartmentDTO(
                        list.get(0).getId(),
                        list.get(0).getName()
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
}