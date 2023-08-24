package org.example.domain;


import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.base.domain.BaseEntity;
import org.example.domain.base.PersonId;
import org.example.domain.enums.Role;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@ToString
@Entity
public class Employee extends BaseEntity<Long> {
    @EmbeddedId
    private PersonId personId;

    @Min(10_000_000)
    private Long salary;


    public Employee() {
    }

    public Employee(PersonId id, Long salary) {
        this.personId = id;
        this.salary = salary;
    }
}
