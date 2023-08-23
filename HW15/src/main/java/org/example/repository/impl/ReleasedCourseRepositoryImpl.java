package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.ReleasedCourse;
import org.example.repository.ReleasedCourseRepository;
import org.example.repository.SemesterRepository;

import javax.persistence.EntityManager;

public class ReleasedCourseRepositoryImpl extends
        BaseRepositoryImpl<ReleasedCourse,Long>
        implements ReleasedCourseRepository {
    public ReleasedCourseRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<ReleasedCourse> getEntityClass() {
        return ReleasedCourse.class;
    }
}
