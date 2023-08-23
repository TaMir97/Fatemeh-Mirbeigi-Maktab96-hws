package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.Student;
import org.example.repository.StudentRepository;
import org.example.repository.StudentTakenCourseRepository;

import javax.persistence.EntityManager;

public class StudentRepositoryImpl extends
        BaseRepositoryImpl<Student,Long>
        implements StudentRepository {
    public StudentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}
