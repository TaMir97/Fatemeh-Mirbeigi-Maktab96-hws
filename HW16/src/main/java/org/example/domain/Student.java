package org.example.domain;

import org.example.base.domain.BaseEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Student extends BaseEntity<Long> {
    @Embedded
    private PersonalInfo personalInfo;
    @Embedded
    private EducationalInfo educationalInfo;

    public Student() {
    }

    private Student(StudentBuilder studentBuilder) {
        personalInfo = studentBuilder.personalInfo;
        educationalInfo = studentBuilder.educationalInfo;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public EducationalInfo getEducationalInfo() {
        return educationalInfo;
    }

    public static class StudentBuilder {
        private PersonalInfo personalInfo;
        private EducationalInfo educationalInfo;

        public StudentBuilder personalInfo(PersonalInfo personalInfo) {
            this.personalInfo = personalInfo;
            return this;
        }

        public StudentBuilder educationalInfo(EducationalInfo educationalInfo) {
            this.educationalInfo = educationalInfo;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "Student " + getId() +
                "\nPersonalInfo{" +
                "firstname='" + personalInfo.getFirstname() + '\'' +
                ", lastname='" + personalInfo.getLastname() + '\'' +
                ", gender=" + personalInfo.getGender() + '\'' +
                ", fatherName='" + personalInfo.getFatherName() + '\'' +
                ", motherName='" + personalInfo.getMotherName() + '\'' +
                ", birthCertificateNumber=" + personalInfo.getBirthCertificateNumber() + '\'' +
                ", birthCertificateId=" + personalInfo.getBirthCertificateId() + '\'' +
                ", homeCity=" + personalInfo.getHomeCity() + '\'' +
                ", birthdate=" + personalInfo.getBirthdate() + '\'' +
                ", marriageState=" + personalInfo.getMarriageState() + '\'' +
                ", supposeBirthCertificateId=" + personalInfo.getSpouseBirthCertificateId() +
                '}' +
                "\nEducationalInfo{" +
                "studentId=" + educationalInfo.getStudentId() + '\'' +
                ", universityName='" + educationalInfo.getUniversityName() + '\'' +
                ", universityType=" + educationalInfo.getUniversityType() + '\'' +
                ", governmentUniversityType=" + educationalInfo.getGovernmentUniversityType() + '\'' +
                ", startedYear=" + educationalInfo.getStartedYear() + '\'' +
                ", grade=" + educationalInfo.getGrade() + '\'' +
                ", city='" + educationalInfo.getCity() + '\'' +
                ", isGraduated=" + educationalInfo.getGraduated() +
                '}';
    }

}
