package org.example.domain;

import org.example.domain.enums.GovernmentUniversity;
import org.example.domain.enums.EducationalGrade;
import org.example.domain.enums.UniversityType;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class EducationalInfo {
    private Long studentId;
    private String universityName;
    @Enumerated(EnumType.STRING)
    private UniversityType universityType;
    @Enumerated(EnumType.STRING)
    private GovernmentUniversity governmentUniversityType;
    private Integer startedYear;
    @Enumerated(EnumType.STRING)
    private EducationalGrade grade;
    private String city;
    private Boolean isGraduated;

    public EducationalInfo() {
    }

    private EducationalInfo(EducationalInfoBuilder educationalInfoBuilder) {
        studentId = educationalInfoBuilder.studentId;
        universityName = educationalInfoBuilder.universityName;
        universityType = educationalInfoBuilder.universityType;
        governmentUniversityType = educationalInfoBuilder.governmentUniversityType;
        startedYear = educationalInfoBuilder.startedYear;
        grade = educationalInfoBuilder.grade;
        city = educationalInfoBuilder.city;
        isGraduated = educationalInfoBuilder.isGraduated;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public UniversityType getUniversityType() {
        return universityType;
    }

    public GovernmentUniversity getGovernmentUniversityType() {
        return governmentUniversityType;
    }

    public Integer getStartedYear() {
        return startedYear;
    }

    public EducationalGrade getGrade() {
        return grade;
    }

    public String getCity() {
        return city;
    }

    public Boolean getGraduated() {
        return isGraduated;
    }

    public static class EducationalInfoBuilder {
        private Long studentId;
        private String universityName;
        private UniversityType universityType;
        private GovernmentUniversity governmentUniversityType;
        private Integer startedYear;
        private EducationalGrade grade;
        private String city;

        private Boolean isGraduated;


        public EducationalInfoBuilder studentId(Long studentId) {
            this.studentId = studentId;
            return this;
        }

        public EducationalInfoBuilder universityName(String universityName) {
            this.universityName = universityName;
            return this;
        }

        public EducationalInfoBuilder universityType(UniversityType universityType) {
            this.universityType = universityType;
            return this;
        }

        public EducationalInfoBuilder governmentUniversityType(GovernmentUniversity governmentUniversityType) {
            this.governmentUniversityType = governmentUniversityType;
            return this;
        }

        public EducationalInfoBuilder startedYear(Integer startedYear) {
            this.startedYear = startedYear;
            return this;
        }

        public EducationalInfoBuilder grade(EducationalGrade grade) {
            this.grade = grade;
            return this;
        }

        public EducationalInfoBuilder city(String city) {
            this.city = city;
            return this;
        }

        public EducationalInfoBuilder isGraduated(String city) {
            this.city = city;
            return this;
        }

        public EducationalInfo build() {

            return new EducationalInfo(this);
        }
    }
}
