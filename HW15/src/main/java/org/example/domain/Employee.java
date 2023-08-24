package org.example.domain;


import javax.persistence.DiscriminatorValue;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.domain.base.Person;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue("Employee")
public class Employee extends Person {

    @Min(10_000_000)
    private Long salary;


    public Employee() {
    }

    public Employee(Long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                "} " + super.toString();
    }
}
