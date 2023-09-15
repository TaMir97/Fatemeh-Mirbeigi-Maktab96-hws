package org.example.domain;

import org.example.domain.enums.GovernmentUniversity;
import org.example.domain.enums.EducationalGrade;
import org.example.domain.enums.UniversityType;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Pattern;

@Embeddable
public class EducationalInfo {
    private Long studentId;
    @Pattern(regexp="^[a-zA-Z]+$", message = "University Name must consist of letters only")
    @Column(name = "university_name")
    private String universityName;
    @Enumerated(EnumType.STRING)
    @Column(name = "university_type")
    private UniversityType universityType;
    @Enumerated(EnumType.STRING)
    @Column(name = "government_university_type")
    private GovernmentUniversity governmentUniversityType;
    @Pattern(regexp="^[0-9]+$", message = "Started Year must consist of numbers only")
    @Column(name = "started_year")
    private Integer startedYear;
    @Enumerated(EnumType.STRING)
    private EducationalGrade grade;
    private String city;
    @Column(name = "is_graduated")
    private Boolean isGraduated;

    public EducationalInfo() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public UniversityType getUniversityType() {
        return universityType;
    }

    public void setUniversityType(UniversityType universityType) {
        this.universityType = universityType;
    }

    public GovernmentUniversity getGovernmentUniversityType() {
        return governmentUniversityType;
    }

    public void setGovernmentUniversityType(GovernmentUniversity governmentUniversityType) {
        this.governmentUniversityType = governmentUniversityType;
    }

    public Integer getStartedYear() {
        return startedYear;
    }

    public void setStartedYear(Integer startedYear) {
        this.startedYear = startedYear;
    }

    public EducationalGrade getGrade() {
        return grade;
    }

    public void setGrade(EducationalGrade grade) {
        this.grade = grade;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getGraduated() {
        return isGraduated;
    }

    public void setGraduated(Boolean graduated) {
        isGraduated = graduated;
    }

    @Override
    public String toString() {
        return "EducationalInfo{" +
                "studentId=" + studentId +
                ", universityName='" + universityName + '\'' +
                ", universityType=" + universityType +
                ", governmentUniversityType=" + governmentUniversityType +
                ", startedYear=" + startedYear +
                ", grade=" + grade +
                ", city='" + city + '\'' +
                ", isGraduated=" + isGraduated +
                '}';
    }
}
