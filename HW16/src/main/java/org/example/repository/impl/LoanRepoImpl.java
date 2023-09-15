package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.Loan;
import org.example.domain.LoanAccount;
import org.example.domain.enums.LoanType;
import org.example.repository.LoanRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

    @Override
    public boolean mortgageLoan(LoanAccount loanAccount) {
        String jpql = "select u from Loan u where u.loanAccount = :loanAccount";
        Query query = entityManger.createQuery(jpql);
        query.setParameter("loanAccount", loanAccount);
        Loan loan = (Loan) query.getSingleResult();
        return loan.getLoanType().equals(LoanType.MORTGAGE);
    }
}
