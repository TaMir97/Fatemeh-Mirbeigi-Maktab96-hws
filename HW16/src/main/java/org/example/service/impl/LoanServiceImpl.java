package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.Loan;
import org.example.domain.LoanAccount;
import org.example.repository.LoanRepository;
import org.example.service.LoanService;

import javax.persistence.criteria.Predicate;
import java.util.List;

public class LoanServiceImpl
        extends BaseServiceImpl<Loan, Long, LoanRepository>
        implements LoanService {
    public LoanServiceImpl(LoanRepository repository) {
        super(repository);
    }

    @Override
    public boolean mortgageLoan(LoanAccount loanAccount) {
        return repository.mortgageLoan(loanAccount);
    }

    @Override
    public List<Loan> installmentsPayments(LoanAccount loanAccount) {
        return repository.installmentsPayments(loanAccount);
    }


}
