package com.snn.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfessorDTO {
    private Integer id;
    private String name;
    private Integer departmentId;
}
