package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.ReleasedCourse;
import org.example.domain.Student;
import org.example.domain.StudentTakenCourse;
import org.example.repository.StudentTakenCourseRepository;

import javax.persistence.EntityManager;

public class StudentTakenCourseRepositoryImpl extends
        BaseRepositoryImpl<StudentTakenCourse, Long>
        implements StudentTakenCourseRepository {

    public StudentTakenCourseRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    public StudentTakenCourse addCourseByGpa(Student student, ReleasedCourse releasedCourse) {
        int totalCredits = student.getTotalCredit();

        StudentTakenCourse newTakenCourse = new StudentTakenCourse();
        newTakenCourse.setReleasedCourse(releasedCourse);
        newTakenCourse.setStudent(student);
        student.getStudentTakenCourseList().add(newTakenCourse);
        student.setTotalCredit(totalCredits + releasedCourse.getCourse().getCredit());
        entityManger.merge(student);
        entityManger.persist(newTakenCourse);

        return newTakenCourse;

    }

    @Override
    public Class<StudentTakenCourse> getEntityClass() {
        return StudentTakenCourse.class;
    }
}
