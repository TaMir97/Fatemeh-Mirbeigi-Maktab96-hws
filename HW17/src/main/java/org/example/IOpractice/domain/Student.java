package org.example.IOpractice.domain;

import org.example.IOpractice.base.domain.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student extends BaseEntity<Long> {
    private String name;

    @OneToOne(mappedBy = "student")
    private Course course;

    public Student() {
    }

    public Student(Long id) {
        super(id);
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
