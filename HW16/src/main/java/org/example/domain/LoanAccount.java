package org.example.domain;

import org.example.base.domain.BaseEntity;
import org.example.util.PasswordGenerator;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class LoanAccount extends BaseEntity<Long> {
    @OneToOne
    @JoinColumn(name = "student_id", unique = true)
    private Student student;
    private String username;
    private String password;

    public LoanAccount() {
        this.username = this.student.getPersonalInfo().getBirthCertificateId().toString();
        this.password = passwordGenerator();
    }

    public Student getStudent() {
        return student;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private String passwordGenerator() {
        int lengthPassword = 8;
        return PasswordGenerator.generatePassword(lengthPassword);
    }
}
