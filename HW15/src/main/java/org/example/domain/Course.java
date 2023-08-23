package org.example.domain;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.example.base.domain.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Course extends BaseEntity<Long> {

    @NotBlank(message = "Course title is required")
    @Size(max = 100, message = "Course title must not exceed 100 characters")
    @Pattern(regexp="^[a-zA-Z]+$", message = "Course title must consist of letters only")
    private String title;

    @Min(value = 1, message = "Credits must be at least 1")
    @Max(value = 10, message = "Credits cannot exceed 10")
    private Integer credit;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Department courseDepartment;

    public Course() {
    }

    public Course(String title, Integer credit, Department courseDepartment) {
        this.title = title;
        this.credit = credit;
        this.courseDepartment = courseDepartment;
    }
}
