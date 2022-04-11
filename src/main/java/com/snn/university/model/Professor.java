package com.snn.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Professor {
    @Id
    private Integer id;
    private String name;
    @ManyToOne
    private Department department;

    public Professor(Integer professorId) {
        this.id = professorId;
    }
}
