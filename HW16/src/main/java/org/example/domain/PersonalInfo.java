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
    private LocalDate birthdate;
    private String homeCity;
    @Enumerated(EnumType.STRING)
    private MarriageState marriageState;
    @Pattern(regexp="^[0-9]+$", message = "Spouse Birth Certificate Id must consist of numbers only")
    @Column(name = "spouse_birth_certificate_id")
    private Long spouseBirthCertificateId;

    public PersonalInfo() {
    }

    private PersonalInfo(PersonalInfoBuilder personalInfoBuilder) {
        firstname = personalInfoBuilder.firstname;
        lastname = personalInfoBuilder.lastname;
        gender = personalInfoBuilder.gender;
        fatherName = personalInfoBuilder.fatherName;
        motherName = personalInfoBuilder.motherName;
        birthCertificateNumber = personalInfoBuilder.birthCertificateNumber;
        birthCertificateId = personalInfoBuilder.birthCertificateId;
        birthdate = personalInfoBuilder.birthdate;
        homeCity = personalInfoBuilder.homeCity;
        marriageState = personalInfoBuilder.marriageState;
        spouseBirthCertificateId = personalInfoBuilder.spouseBirthCertificateId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public Long getBirthCertificateNumber() {
        return birthCertificateNumber;
    }

    public Long getBirthCertificateId() {
        return birthCertificateId;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public MarriageState getMarriageState() {
        return marriageState;
    }

    public Long getSpouseBirthCertificateId() {
        return spouseBirthCertificateId;
    }

    public static class PersonalInfoBuilder {
        private String firstname;
        private String lastname;
        private Gender gender;
        private String fatherName;
        private String motherName;
        private Long birthCertificateNumber;
        private Long birthCertificateId;
        private LocalDate birthdate;
        private String homeCity;
        private MarriageState marriageState;
        private Long spouseBirthCertificateId;


        public PersonalInfoBuilder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public PersonalInfoBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public PersonalInfoBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public PersonalInfoBuilder fatherName(String fatherName) {
            this.fatherName = fatherName;
            return this;
        }

        public PersonalInfoBuilder motherName(String motherName) {
            this.motherName = motherName;
            return this;
        }

        public PersonalInfoBuilder birthCertificateNumber(Long birthCertificateNumber) {
            this.birthCertificateNumber = birthCertificateNumber;
            return this;
        }

        public PersonalInfoBuilder birthCertificateId(Long birthCertificateId) {
            this.birthCertificateId = birthCertificateId;
            return this;
        }

        public PersonalInfoBuilder birthdate(LocalDate birthdate) {
            this.birthdate = birthdate;
            return this;
        }
        public PersonalInfoBuilder homeCity(String homeCity) {
            this.homeCity = homeCity;
            return this;
        }

        public PersonalInfoBuilder marriageState(MarriageState marriageState) {
            this.marriageState = marriageState;
            return this;
        }

        public PersonalInfoBuilder spouseBirthCertificateId(Long spouseBirthCertificateId) {
            this.spouseBirthCertificateId = spouseBirthCertificateId;
            return this;
        }

        public PersonalInfo build() {
            return new PersonalInfo(this);
        }
    }


}
