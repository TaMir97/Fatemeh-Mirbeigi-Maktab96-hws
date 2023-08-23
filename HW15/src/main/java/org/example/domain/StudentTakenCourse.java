package org.example.domain;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.base.domain.BaseEntity;
import org.example.domain.enums.CourseState;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class StudentTakenCourse extends BaseEntity<Long> {
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "released_course_id")
    private ReleasedCourse releasedCourse;

    @DecimalMin(value = "0.0", message = "Mark must be greater than or equal to 0.0")
    @DecimalMax(value = "20.0", message = "Mark must be less than or equal to 10000.0")
    private Double mark;

    @Enumerated(EnumType.STRING)
    private CourseState courseState;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Student student;


}
