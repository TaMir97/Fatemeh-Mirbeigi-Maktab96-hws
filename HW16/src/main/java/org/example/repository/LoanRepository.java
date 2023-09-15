package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.domain.Loan;
import org.example.domain.LoanAccount;

import java.util.List;

public interface LoanRepository extends BaseRepository<Loan, Long> {
    boolean mortgageLoan(LoanAccount loanAccount);
    List<Loan> installmentsPayments(LoanAccount loanAccount);

}
