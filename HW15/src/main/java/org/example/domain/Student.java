package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.base.domain.BaseEntity;
import org.example.domain.base.PersonId;
import org.example.domain.enums.StudentState;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Student extends BaseEntity<Long> {
    @EmbeddedId
    private PersonId id;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "student_department_id")
    private Department studentDepartment;

    @OneToMany(mappedBy = "student",
            fetch = FetchType.EAGER)
    private List<StudentTakenCourse> studentTakenCourseList;

    @Column(name = "total_credits")
    private Integer totalCredit;

    private Double gpa;

    @Column(name = "student_state")
    private StudentState studentState;
    public Student() {
    }

    public Student(Department studentDepartment,
                   List<StudentTakenCourse> studentTakenCourseList,
                   Integer totalCredit,
                   Double gpa,
                   StudentState studentState) {
        this.studentDepartment = studentDepartment;
        this.studentTakenCourseList = studentTakenCourseList;
        this.totalCredit = totalCredit;
        this.gpa = gpa;
        this.studentState = studentState;
    }

    public PersonId getId() {
        return id;
    }

    public void setId(PersonId id) {
        this.id = id;
    }

    public Department getStudentDepartment() {
        return studentDepartment;
    }

    public void setStudentDepartment(Department studentDepartment) {
        this.studentDepartment = studentDepartment;
    }

    public List<StudentTakenCourse> getStudentTakenCourseList() {
        return studentTakenCourseList;
    }

    public void setStudentTakenCourseList(List<StudentTakenCourse> studentTakenCourseList) {
        this.studentTakenCourseList = studentTakenCourseList;
    }

    public void setTotalCredit() {
        for (StudentTakenCourse takenCourse : studentTakenCourseList) {
            this.totalCredit += takenCourse.getReleasedCourse().getCourse().getCredit();
        }
    }

    public Integer getTotalCredit() {
        return totalCredit;
    }

    public void setGpa() {
        int number = 0;
        for (StudentTakenCourse takenCourse : studentTakenCourseList) {
            this.gpa += takenCourse.getMark();
            number++;
        }
        this.gpa/=number;
    }

    public Double getGpa() {
        return gpa;
    }

    public StudentState getStudentState() {
        return studentState;
    }

    public void setStudentState(StudentState studentState) {
        this.studentState = studentState;
    }
}
