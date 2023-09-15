package org.example.domain;

import org.example.base.domain.BaseEntity;
import org.example.domain.enums.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class Student extends BaseEntity<Long> {
    @Pattern(regexp="^[a-zA-Z]+$", message = "FirstName must consist of letters only")
    private String firstname;
    @Pattern(regexp="^[a-zA-Z]+$", message = "Lastname must consist of letters only")
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Pattern(regexp="^[a-zA-Z]+$", message = "Father Name must consist of letters only")
    private String fatherName;
    @Pattern(regexp="^[a-zA-Z]+$", message = "Mother Name must consist of letters only")
    private String motherName;
    @Pattern(regexp="^[0-9]+$", message = "Birth Certificate Number must consist of numbers only")
    @Column(name = "birth_certificate_number")
    private Long birthCertificateNumber;
    @Pattern(regexp="^[0-9]+$", message = "Birth Certificate Id must consist of numbers only")
    @Column(name = "birth_certificate_id")
    private Long birthCertificateId;
    private String birthdate;
    private String homeCity;
    @Enumerated(EnumType.STRING)
    private MarriageState marriageState;
    @Pattern(regexp="^[0-9]+$", message = "Spouse Birth Certificate Id must consist of numbers only")
    @Column(name = "spouse_birth_certificate_id")
    private Long spouseBirthCertificateId;

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
    public Student() {
    }

    @Column(name = "is_graduated")
    private Boolean isGraduated;


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


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Long getBirthCertificateNumber() {
        return birthCertificateNumber;
    }

    public void setBirthCertificateNumber(Long birthCertificateNumber) {
        this.birthCertificateNumber = birthCertificateNumber;
    }

    public Long getBirthCertificateId() {
        return birthCertificateId;
    }

    public void setBirthCertificateId(Long birthCertificateId) {
        this.birthCertificateId = birthCertificateId;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    public MarriageState getMarriageState() {
        return marriageState;
    }

    public void setMarriageState(MarriageState marriageState) {
        this.marriageState = marriageState;
    }

    public Long getSpouseBirthCertificateId() {
        return spouseBirthCertificateId;
    }

    public void setSpouseBirthCertificateId(Long spouseBirthCertificateId) {
        this.spouseBirthCertificateId = spouseBirthCertificateId;
    }




    @Override
    public String toString() {
        return "Student " + getId() +
                "\nPersonalInfo{" +
                "firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", gender=" + getGender() + '\'' +
                ", fatherName='" + getFatherName() + '\'' +
                ", motherName='" + getMotherName() + '\'' +
                ", birthCertificateNumber=" + getBirthCertificateNumber() + '\'' +
                ", birthCertificateId=" + getBirthCertificateId() + '\'' +
                ", homeCity=" + getHomeCity() + '\'' +
                ", birthdate=" + getBirthdate() + '\'' +
                ", marriageState=" + getMarriageState() + '\'' +
                ", supposeBirthCertificateId=" + getSpouseBirthCertificateId() +
                '}' +
                "\nEducationalInfo{" +
                "studentId=" + getStudentId() + '\'' +
                ", universityName='" + getUniversityName() + '\'' +
                ", universityType=" + getUniversityType() + '\'' +
                ", governmentUniversityType=" + getGovernmentUniversityType() + '\'' +
                ", startedYear=" + getStartedYear() + '\'' +
                ", grade=" + getGrade() + '\'' +
                ", city='" + getCity() + '\'' +
                ", isGraduated=" + getGraduated() +
                '}';
    }

}
