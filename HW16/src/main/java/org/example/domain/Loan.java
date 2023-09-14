package org.example.domain;

import org.example.base.domain.BaseEntity;
import org.example.domain.enums.LoanType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Loan extends BaseEntity<Long> {
    @ManyToOne
    private LoanAccount loanAccount;
    @Enumerated(EnumType.STRING)
    private LoanType loanType;
    private Long totalAmount;
    private LocalDate registerDate;

    public Loan() {
    }

    public LoanAccount getLoanAccount() {
        return loanAccount;
    }

    public void setLoanAccount(LoanAccount loanAccount) {
        this.loanAccount = loanAccount;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanAccount=" + loanAccount +
                ", loanType=" + loanType +
                ", totalAmount=" + totalAmount +
                ", registerDate=" + registerDate +
                "} ";
    }
}
