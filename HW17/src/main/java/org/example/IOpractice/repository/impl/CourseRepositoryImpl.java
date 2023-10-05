package org.example.IOpractice.repository.impl;

import org.example.IOpractice.base.repository.impl.BaseRepositoryImpl;
import org.example.IOpractice.domain.Course;
import org.example.IOpractice.domain.Student;
import org.example.IOpractice.repository.CourseRepository;
import org.example.IOpractice.repository.StudentRepository;

import javax.persistence.EntityManager;

public class CourseRepositoryImpl
        extends BaseRepositoryImpl<Course,Long>
        implements CourseRepository {
    public CourseRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }
}
