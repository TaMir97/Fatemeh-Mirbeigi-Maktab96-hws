package org.example.service;

import org.example.base.service.BaseService;
import org.example.domain.Loan;
import org.example.domain.LoanAccount;

public interface LoanService extends BaseService<Loan,Long> {
    boolean mortgageLoan(LoanAccount loanAccount);

}
