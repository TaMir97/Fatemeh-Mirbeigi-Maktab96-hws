package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.Course;
import org.example.domain.Teacher;
import org.example.repository.CourseRepository;
import org.example.repository.TeacherRepository;

import javax.persistence.EntityManager;

public class TeacherRepositoryImpl
        extends BaseRepositoryImpl<Teacher,Long>
        implements TeacherRepository {

    public TeacherRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Teacher> getEntityClass() {
        return Teacher.class;
    }


}
