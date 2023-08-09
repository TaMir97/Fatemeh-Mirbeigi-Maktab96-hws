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
    private Degree degree;
    @Column(name = "academic_rank")
    private AcademicRank academicRank;
    private BigDecimal payment;


    public Teacher(Long personId, String firstname, String lastname, Date birthdate, Long teacherNo, Degree degree, AcademicRank academicRank, BigDecimal payment) {
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

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public AcademicRank getAcademicRank() {
        return academicRank;
    }

    public void setAcademicRank(AcademicRank academicRank) {
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
