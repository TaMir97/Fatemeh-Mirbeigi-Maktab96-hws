package org.example.IOpractice.repository.impl;

import org.example.IOpractice.base.repository.impl.BaseRepositoryImpl;
import org.example.IOpractice.domain.Student;
import org.example.IOpractice.repository.StudentRepository;

import javax.persistence.EntityManager;

public class StudentRepositoryImpl
        extends BaseRepositoryImpl<Student,Long>
        implements StudentRepository {


    public StudentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}