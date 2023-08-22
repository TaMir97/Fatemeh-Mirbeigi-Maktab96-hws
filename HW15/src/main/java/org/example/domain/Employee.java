package org.example.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.domain.base.Person;
import org.example.domain.enums.Role;


@Getter
@Setter
@ToString
public class Employee extends Person {
    @Min(10_000_000)
    private Long salary;

    public Employee() {
    }

    public Employee(String firstname, String lastname, String username, String password, String email, Role role, Long salary) {
        super(firstname, lastname, username, password, email, role);
        this.salary = salary;
    }
}
