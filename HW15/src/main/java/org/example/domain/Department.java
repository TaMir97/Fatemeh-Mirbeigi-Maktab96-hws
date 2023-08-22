package org.example.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.base.domain.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Department extends BaseEntity<Long> {

    @NotBlank(message = "First name is required")
    @Size(max = 100, message = "First name must not exceed 100 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "LastName must consist of letters only")
    private String departmentName;

    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    @OneToMany(mappedBy = "teacherDepartment",
            fetch = FetchType.EAGER)
    private List<Teacher> teacherList;

    @OneToMany(mappedBy = "studentDepartment",
            fetch = FetchType.EAGER)
    private List<Student> studentList;

    @OneToMany(mappedBy = "courseDepartment",
            fetch = FetchType.EAGER)
    private List<Course> courseList;


}
