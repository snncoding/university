package com.snn.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    private Integer id;
    private String name;
    @ManyToOne
    private Department department;
    private Integer credits;

    public Course(Integer courseId) {
        this.id = courseId;
    }
}
