package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.Loan;
import org.example.repository.LoanRepository;
import org.example.service.LoanService;

public class LoanServiceImpl
        extends BaseServiceImpl<Loan, Long, LoanRepository>
        implements LoanService {
    public LoanServiceImpl(LoanRepository repository) {
        super(repository);
    }
}