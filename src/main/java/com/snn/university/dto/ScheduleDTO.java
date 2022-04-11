package com.snn.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScheduleDTO {
    private Integer id;
    private Integer professorId;
    private Integer courseId;
    private Integer semester;
    private Integer year;

}
