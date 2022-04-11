package com.snn.university.controller;

import com.snn.university.dto.SearchDTO;
import com.snn.university.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private ScheduleService service;

    @GetMapping
    public List<SearchDTO> search(){
        return service.search();
    }
}
