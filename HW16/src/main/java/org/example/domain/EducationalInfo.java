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

    public static class EducationalInfoBuilder {
        private Long studentId;
        private String universityName;
        private UniversityType universityType;
        private GovernmentUniversity governmentUniversityType;
        private Integer startedYear;
        private EducationalGrade grade;
        private String city;

        public EducationalInfoBuilder setStudentId(Long studentId) {
            this.studentId = studentId;
            return this;
        }

        public EducationalInfoBuilder setUniversityName(String universityName) {
            this.universityName = universityName;
            return this;
        }

        public EducationalInfoBuilder setUniversityType(UniversityType universityType) {
            this.universityType = universityType;
            return this;
        }

        public EducationalInfoBuilder setGovernmentUniversityType(GovernmentUniversity governmentUniversityType) {
            this.governmentUniversityType = governmentUniversityType;
            return this;
        }

        public EducationalInfoBuilder setStartedYear(Integer startedYear) {
            this.startedYear = startedYear;
            return this;
        }

        public EducationalInfoBuilder setGrade(EducationalGrade grade) {
            this.grade = grade;
            return this;
        }

        public EducationalInfoBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public EducationalInfo build() {

            return new EducationalInfo(this);
        }
    }
}
