package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.CardInfo;
import org.example.domain.LoanAccount;
import org.example.domain.Student;
import org.example.repository.LoanAccountRepository;
import org.example.service.LoanAccountService;

public class LoanAccountServiceImpl
        extends BaseServiceImpl<LoanAccount, Long, LoanAccountRepository>
        implements LoanAccountService {
    public LoanAccountServiceImpl(LoanAccountRepository repository) {
        super(repository);
    }

    @Override
    public LoanAccount signUp(Student student, CardInfo cardInfo) {
        LoanAccount newLoanAccount = new LoanAccount();
        newLoanAccount.setStudent(student);
        newLoanAccount.setCardInfo(cardInfo);
        return save(newLoanAccount);
    }

    @Override
    public LoanAccount login(String username, String password) {
        return repository.login(username,password);
    }

    @Override
    public boolean graduationState(LoanAccount loanAccount) {

        return false;
    }
}
