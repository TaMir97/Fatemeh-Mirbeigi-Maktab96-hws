package org.example.domain;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.base.domain.BaseEntity;
import org.example.domain.base.PersonId;
import org.example.domain.enums.TeacherLevel;

import javax.persistence.*;
import java.util.List;


@ToString
@Entity
public class Teacher extends BaseEntity<Long> {
    @EmbeddedId
    private PersonId id;

    private Integer totalCredit;

    private Long baseSalary;

    @Enumerated(EnumType.STRING)
    private TeacherLevel teacherLevel;

    private Long totalSalary;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Department teacherDepartment;

    @OneToMany(mappedBy = "teacher",
            fetch = FetchType.LAZY)
    private List<ReleasedCourse> releasedCourses;



    public void setTotalCredit() {
        for (ReleasedCourse taughtCourse : releasedCourses) {
            this.totalCredit += taughtCourse.getCourse().getCredit();
        }
    }

    public Integer getTotalCredit() {
        return totalCredit;
    }

    public void setBaseSalary(Long baseSalary) {
        if (this.teacherLevel.equals("ADJUNCT"))
            this.baseSalary = 0L;
        else
            this.baseSalary = baseSalary;
    }

    public Long getBaseSalary() {
        return baseSalary;
    }

    public void setTotalSalary() {
        this.totalSalary = this.baseSalary + this.totalCredit * 1_000_000L;
    }

    public Long getTotalSalary() {
        return totalSalary;
    }

    public PersonId getId() {
        return id;
    }

    public void setId(PersonId id) {
        this.id = id;
    }

    public TeacherLevel getTeacherLevel() {
        return teacherLevel;
    }

    public void setTeacherLevel(TeacherLevel teacherLevel) {
        this.teacherLevel = teacherLevel;
    }

    public Department getTeacherDepartment() {
        return teacherDepartment;
    }

    public void setTeacherDepartment(Department teacherDepartment) {
        this.teacherDepartment = teacherDepartment;
    }

    public List<ReleasedCourse> getReleasedCourses() {
        return releasedCourses;
    }

    public void setReleasedCourses(List<ReleasedCourse> releasedCourses) {
        this.releasedCourses = releasedCourses;
    }
}
