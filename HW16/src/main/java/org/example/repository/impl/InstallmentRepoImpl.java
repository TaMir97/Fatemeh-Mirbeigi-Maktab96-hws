package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.Installment;
import org.example.repository.InstallmentRepository;

import javax.persistence.EntityManager;

public class InstallmentRepoImpl extends
        BaseRepositoryImpl<Installment,Long>
        implements InstallmentRepository {
    public InstallmentRepoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Installment> getEntityClass() {
        return Installment.class;
    }
}
