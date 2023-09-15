package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.domain.CardInfo;
import org.example.domain.LoanAccount;
import org.example.domain.Student;

public interface LoanAccountRepository extends BaseRepository<LoanAccount, Long> {
    LoanAccount findByUsername(Long birthCertificateId);

    LoanAccount login(String username, String password);
    boolean graduationState(LoanAccount loanAccount);


}
