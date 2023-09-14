package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.LoanAccount;
import org.example.repository.LoanAccountRepository;
import org.example.service.LoanAccountService;

public class LoanAccountServiceImpl
        extends BaseServiceImpl<LoanAccount, Long, LoanAccountRepository>
        implements LoanAccountService {
    public LoanAccountServiceImpl(LoanAccountRepository repository) {
        super(repository);
    }
}
