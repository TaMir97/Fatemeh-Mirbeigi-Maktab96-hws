package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.Student;
import org.example.domain.enums.*;
import org.example.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentRepoImpl extends
        BaseRepositoryImpl<Student,Long>
        implements StudentRepository {
    public StudentRepoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }


    @Override
    public Student findByBirthCertificateId(Long birthCertificateId) {
        String jpql = "select u from Student u where u.birthCertificateId = :birthCertificateId";
        Query query = entityManger.createQuery(jpql);
        query.setParameter("birthCertificateId", birthCertificateId);
        return (Student) query.getSingleResult();
    }
}
