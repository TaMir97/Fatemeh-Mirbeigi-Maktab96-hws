package org.example.domain;

import org.example.base.domain.BaseEntity;
import org.example.util.PasswordGenerator;

import javax.persistence.*;

@Entity
public class LoanAccount extends BaseEntity<Long> {
    @OneToOne
    @JoinColumn(name = "student_id", unique = true)
    private Student student;
    private String username;
    private String password;
    @Embedded
    private CardInfo cardInfo;

    public LoanAccount() {
    }

    public LoanAccount(Student student) {
        this.student = student;
        if (this.student != null) {
            this.username = this.student.getPersonalInfo().getBirthCertificateId().toString();
            this.password = passwordGenerator();
        }
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
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

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    private String passwordGenerator() {
        int lengthPassword = 8;
        return PasswordGenerator.generatePassword(lengthPassword);
    }

}
