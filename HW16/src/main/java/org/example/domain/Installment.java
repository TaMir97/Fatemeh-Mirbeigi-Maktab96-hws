package org.example.domain;

import org.example.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Installment extends BaseEntity<Long> {
    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;
    private LocalDate dateOfPayment;
    private Long payedAmount;
}
