package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.Course;
import org.example.repository.CourseRepository;

import javax.persistence.EntityManager;

public class CourseRepositoryImpl extends
        BaseRepositoryImpl<Course,Long>
        implements CourseRepository {

    public CourseRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }
}
