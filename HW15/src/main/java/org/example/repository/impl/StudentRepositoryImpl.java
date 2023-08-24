package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.Student;
import org.example.repository.StudentRepository;
import org.example.repository.StudentTakenCourseRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentRepositoryImpl extends
        BaseRepositoryImpl<Student,Long>
        implements StudentRepository {
    public StudentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
    public Student findByUsernameAndPassword(String username, String password) {
        CriteriaBuilder criteriaBuilder = entityManger.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);

        Predicate usernamePredicate = criteriaBuilder.equal(studentRoot.get("id").get("username"), username);
        Predicate passwordPredicate = criteriaBuilder.equal(studentRoot.get("id").get("password"), password);
        Predicate combinedPredicate = criteriaBuilder.and(usernamePredicate, passwordPredicate);

        criteriaQuery.where(combinedPredicate);
        List<Student> foundStudents = entityManger.createQuery(criteriaQuery).getResultList();

        if (!foundStudents.isEmpty()) {
            return foundStudents.get(0);
        }

        return null;
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}
