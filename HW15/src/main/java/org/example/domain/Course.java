package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import org.example.base.domain.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;

@Getter
@Setter
@Entity
public class Course extends BaseEntity<Long> {

    @NotBlank(message = "Course title is required")
    @Size(max = 100, message = "Course title must not exceed 100 characters")
    @Pattern(regexp="^[a-zA-Z0-9]+$", message = "Course title must consist of letters and numbers only")
    private String title;

    @Min(value = 1, message = "Credits must be at least 1")
    @Max(value = 10, message = "Credits cannot exceed 10")
    private Integer credit;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "course_department_id")
    private Department courseDepartment;

    public Course() {
    }

    public Course(String title, Integer credit, Department courseDepartment) {
        this.title = title;
        this.credit = credit;
        this.courseDepartment = courseDepartment;
    }
}
