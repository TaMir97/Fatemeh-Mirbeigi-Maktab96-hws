package org.example.log4j.domain;


import org.example.log4j.base.domain.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Stud3nt extends Person {
    @Column(name = "student_number")
    private Long studentNo;
    @Column(name = "study_field")
    private String studyField;
    @Column(name = "started_year")
    private String startedYear;

    public Stud3nt(Long personId, String firstname, String lastname, Date birthdate, Long studentNo, String studyField, String startedYear) {
        super(personId, firstname, lastname, birthdate);
        this.studentNo = studentNo;
        this.studyField = studyField;
        this.startedYear = startedYear;
    }

    public Stud3nt() {
    }

    public Long getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Long studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudyField() {
        return studyField;
    }

    public void setStudyField(String studyField) {
        this.studyField = studyField;
    }

    public String getStartedYear() {
        return startedYear;
    }

    public void setStartedYear(String startedYear) {
        this.startedYear = startedYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNo=" + studentNo +
                ", studyField='" + studyField + '\'' +
                ", startedYear='" + startedYear + '\'' +
                '}';
    }
}
