package org.example.repository.impl;

import org.example.base.repository.BaseRepository;
import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.Department;
import org.example.domain.Semester;
import org.example.repository.DepartmentRepository;
import org.example.repository.SemesterRepository;

import javax.persistence.EntityManager;

public class DepartmentRepositoryImpl extends
        BaseRepositoryImpl<Department,Long>
        implements DepartmentRepository {
    public DepartmentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Department> getEntityClass() {
        return Department.class;
    }
}
