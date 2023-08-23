package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.StudentTakenCourse;
import org.example.repository.StudentTakenCourseRepository;

import javax.persistence.EntityManager;

public class StudentTakenCourseRepositoryImpl extends
        BaseRepositoryImpl<StudentTakenCourse,Long>
        implements StudentTakenCourseRepository {

    public StudentTakenCourseRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public Class<StudentTakenCourse> getEntityClass() {
        return StudentTakenCourse.class;
    }
}
