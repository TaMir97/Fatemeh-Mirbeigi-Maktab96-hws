package ir.maktab.domain;

import ir.maktab.base.domain.Person;
import ir.maktab.domain.enumPack.AcademicRank;
import ir.maktab.domain.enumPack.Degree;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Teacher extends Person {
    @Column(name = "teacher_number")
    private Long teacherNo;
    private String degree;
    @Column(name = "academic_rank")
    private String academicRank;
    private BigDecimal payment;


    public Teacher(Long personId, String firstname, String lastname, Date birthdate, Long teacherNo, String degree, String academicRank, BigDecimal payment) {
        super(personId, firstname, lastname, birthdate);
        this.teacherNo = teacherNo;
        this.degree = degree;
        this.academicRank = academicRank;
        this.payment = payment;
    }

    public Teacher() {
    }

    public Long getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(Long teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getAcademicRank() {
        return academicRank;
    }

    public void setAcademicRank(String academicRank) {
        this.academicRank = academicRank;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherNo=" + teacherNo +
                ", degree=" + degree +
                ", academicRank=" + academicRank +
                ", payment=" + payment +
                '}';
    }
}
