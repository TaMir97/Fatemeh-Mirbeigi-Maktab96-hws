package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.LoanAccount;
import org.example.repository.LoanAccountRepository;

import javax.persistence.EntityManager;

public class LoanAccountRepoImpl extends
        BaseRepositoryImpl<LoanAccount, Long>
        implements LoanAccountRepository {
    public LoanAccountRepoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<LoanAccount> getEntityClass() {
        return LoanAccount.class;
    }
}
