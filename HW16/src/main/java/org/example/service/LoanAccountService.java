package org.example.service;

import org.example.base.service.BaseService;
import org.example.domain.CardInfo;
import org.example.domain.LoanAccount;
import org.example.domain.Student;

public interface LoanAccountService extends BaseService<LoanAccount,Long> {
    LoanAccount signUp(Student student, CardInfo cardInfo);

    LoanAccount login(String username, String password);

    boolean graduationState(LoanAccount loanAccount);

}
