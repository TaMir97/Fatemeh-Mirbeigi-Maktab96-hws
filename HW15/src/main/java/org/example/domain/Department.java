package org.example.domain;


import lombok.Getter;
import lombok.Setter;
import org.example.base.domain.BaseEntity;
import javax.validation.constraints.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Department extends BaseEntity<Long> {

    @NotBlank(message = "First name is required")
    @Size(max = 100, message = "First name must not exceed 100 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "LastName must consist of letters only")
    @Column(name = "department_name")
    private String departmentName;

    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }


}
