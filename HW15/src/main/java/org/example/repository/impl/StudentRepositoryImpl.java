package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.Student;
import org.example.repository.StudentRepository;
import org.example.repository.StudentTakenCourseRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

public class StudentRepositoryImpl extends
        BaseRepositoryImpl<Student,Long>
        implements StudentRepository {
    public StudentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
    public Student findByUsernameAndPassword(String username, String password) {
        CriteriaBuilder cb = entityManger.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);

        Predicate usernamePredicate = cb.equal(root.get("username"), username);
        Predicate passwordPredicate = cb.equal(root.get("password"), password);

        query.select(root).where(cb.and(usernamePredicate, passwordPredicate));
        List<Student> resultList = entityManger.createQuery(query).getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    @Override
    public Student findByFirstnameAndLastname(String firstname, String lastname) {
        CriteriaBuilder cb = entityManger.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);

        Predicate firstnamePredicate = cb.equal(root.get("firstname"), firstname);
        Predicate lastnamePredicate = cb.equal(root.get("lastname"), lastname);

        query.select(root).where(cb.and(firstnamePredicate, lastnamePredicate));
        List<Student> resultList = entityManger.createQuery(query).getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    @Override
    public Student findByEmail(String email) {
        CriteriaBuilder cb = entityManger.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);

        Predicate emailPredicate = cb.equal(root.get("email"), email);

        query.select(root).where(emailPredicate);
        List<Student> resultList = entityManger.createQuery(query).getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    @Override
    public List<Student> studentsWithHighGPA() {
        CriteriaBuilder cb = entityManger.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> studentRoot = query.from(Student.class);

        Join<Object, Object> takenCoursesJoin = studentRoot.join("studentTakenCourseList");
        Join<Object, Object> releasedCourseJoin = takenCoursesJoin.join("releasedCourse");
        Join<Object, Object> courseJoin = releasedCourseJoin.join("course");

        Predicate gpaPredicate = cb.greaterThanOrEqualTo(courseJoin.get("gpa"), 18.0);


        query.select(studentRoot)
                .distinct(true)
                .where(gpaPredicate);

        return entityManger.createQuery(query).getResultList();
    }

    @Override
    public List<Student> studentsWithLowGPA() {
        CriteriaBuilder cb = entityManger.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> studentRoot = query.from(Student.class);

        Join<Object, Object> takenCoursesJoin = studentRoot.join("studentTakenCourseList");
        Join<Object, Object> releasedCourseJoin = takenCoursesJoin.join("releasedCourse");
        Join<Object, Object> courseJoin = releasedCourseJoin.join("course");

        Predicate gpaPredicate = cb.lessThan(courseJoin.get("gpa"), 18.0);

        query.select(studentRoot)
                .distinct(true)
                .where(gpaPredicate);

        return entityManger.createQuery(query).getResultList();
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}
