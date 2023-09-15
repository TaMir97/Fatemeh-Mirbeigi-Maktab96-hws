package org.example.domain;

import org.example.domain.enums.Gender;
import org.example.domain.enums.MarriageState;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Embeddable
public class PersonalInfo {
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

    public PersonalInfo() {
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
        return "PersonalInfo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender=" + gender +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", birthCertificateNumber=" + birthCertificateNumber +
                ", birthCertificateId=" + birthCertificateId +
                ", birthdate=" + birthdate +
                ", homeCity='" + homeCity + '\'' +
                ", marriageState=" + marriageState +
                ", spouseBirthCertificateId=" + spouseBirthCertificateId +
                '}';
    }
}
