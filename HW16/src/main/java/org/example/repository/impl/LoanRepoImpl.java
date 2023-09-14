package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.Loan;
import org.example.repository.LoanRepository;

import javax.persistence.EntityManager;

public class LoanRepoImpl extends
        BaseRepositoryImpl<Loan,Long>
        implements LoanRepository {
    public LoanRepoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Loan> getEntityClass() {
        return Loan.class;
    }
}
