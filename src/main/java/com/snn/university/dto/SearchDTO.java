package com.snn.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SearchDTO {
    private String name;
    private List<String> courses;
}
