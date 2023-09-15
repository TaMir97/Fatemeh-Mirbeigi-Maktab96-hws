package org.example.service;

import org.example.base.service.BaseService;
import org.example.domain.Loan;
import org.example.domain.LoanAccount;

import java.util.List;

public interface LoanService extends BaseService<Loan,Long> {
    boolean mortgageLoan(LoanAccount loanAccount);
    List<Loan> installmentsPayments(LoanAccount loanAccount);



}
