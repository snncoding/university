package com.snn.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseDTO {
    private Integer id;
    private String name;
    private Integer departmentId;
    private Integer credits;
}
