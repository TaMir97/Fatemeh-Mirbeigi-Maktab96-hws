package org.example.domain;

import org.example.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Installment extends BaseEntity<Long> {
    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;
    @Column(name = "date_of_payment")
    private LocalDate dateOfPayment;
    @Column(name = "payed_amount")
    private Long payedAmount;

    public Installment() {
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public Long getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(Long payedAmount) {
        this.payedAmount = payedAmount;
    }

    @Override
    public String toString() {
        return "Installment{" +
                "loan=" + loan +
                ", dateOfPayment=" + dateOfPayment +
                ", payedAmount=" + payedAmount +
                "} ";
    }
}
