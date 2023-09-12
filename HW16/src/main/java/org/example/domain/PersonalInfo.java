package org.example.domain;

import org.example.domain.enums.Gender;
import org.example.domain.enums.MarriageState;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Embeddable
public class PersonalInfo {
    private String firstname;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String fatherName;
    private String motherName;
    private Long birthCertificateNumber;
    private Long birthCertificateId;
    private LocalDate birthdate;
    @Enumerated(EnumType.STRING)
    private MarriageState marriageState;

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
        marriageState = personalInfoBuilder.marriageState;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public MarriageState getMarriageState() {
        return marriageState;
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
        private MarriageState marriageState;

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

        public PersonalInfoBuilder marriageState(MarriageState marriageState) {
            this.marriageState = marriageState;
            return this;
        }

        public PersonalInfo build() {
            return new PersonalInfo(this);
        }
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
                ", marriageState=" + marriageState +
                '}';
    }
}
