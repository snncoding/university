package com.snn.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    /*
    Id column does not exist in the code assignment, but I prefer to use id column.
    Because it is easy to understand and to manage. Other way I could use composite key
     */
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Professor professor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;

    private Integer semester;

    private Integer year;
}
