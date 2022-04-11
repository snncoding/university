package com.snn.university.controller;

import com.snn.university.repository.ScheduleRepository;
import com.snn.university.service.ScheduleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class SearchControllerTest {

    @Mock
    private ScheduleRepository repository;

    @InjectMocks
    private ScheduleService service;



    @BeforeEach
    void setUp() {
    }

    @Test
    void search() {
    }
}