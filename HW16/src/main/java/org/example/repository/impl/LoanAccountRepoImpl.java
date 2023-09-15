package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.CardInfo;
import org.example.domain.LoanAccount;
import org.example.domain.Student;
import org.example.repository.LoanAccountRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

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


    @Override
    public LoanAccount findByUsername(Long birthCertificateId) {
        CriteriaBuilder cb = entityManger.getCriteriaBuilder();
        CriteriaQuery<LoanAccount> query = cb.createQuery(LoanAccount.class);
        Root<LoanAccount> root = query.from(LoanAccount.class);

        Predicate birthCertificateIdPredicate = cb.equal(root.get("username"), birthCertificateId);

        query.select(root).where(cb.and(birthCertificateIdPredicate));
        List<LoanAccount> resultList = entityManger.createQuery(query).getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    @Override
    public LoanAccount login(String username, String password) {
        String jpql = "select u from LoanAccount u where u.username = :username and u.password = :password";
        Query query = entityManger.createQuery(jpql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (LoanAccount) query.getSingleResult();
    }

    @Override
    public boolean graduationState(LoanAccount loanAccount) {
        String username = loanAccount.getUsername();
        String jpql = "select lo from LoanAccount lo where lo.username = :username";
        Query query = entityManger.createQuery(jpql);
        query.setParameter("username", username);
        LoanAccount loanAccount1 = (LoanAccount) query.getSingleResult();
        Student student = loanAccount1.getStudent();
        return student.getGraduated();
    }
}
