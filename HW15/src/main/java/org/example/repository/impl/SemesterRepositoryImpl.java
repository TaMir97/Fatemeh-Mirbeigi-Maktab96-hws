package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.Semester;
import org.example.repository.SemesterRepository;
import org.example.repository.StudentRepository;

import javax.persistence.EntityManager;

public class SemesterRepositoryImpl extends
        BaseRepositoryImpl<Semester,Long>
        implements SemesterRepository {
    public SemesterRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Semester> getEntityClass() {
        return Semester.class;
    }
}
