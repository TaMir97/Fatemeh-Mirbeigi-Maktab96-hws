package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.ReleasedCourse;
import org.example.domain.Student;
import org.example.repository.ReleasedCourseRepository;
import org.example.repository.SemesterRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class ReleasedCourseRepositoryImpl extends
        BaseRepositoryImpl<ReleasedCourse,Long>
        implements ReleasedCourseRepository {
    public ReleasedCourseRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    public List<ReleasedCourse> findEligibleReleasedCoursesForStudent(Long studentId) {
        Student student = entityManger.find(Student.class, studentId);
        double gpa = student.getGpa();
        int totalCredits = student.getTotalCredit();

        String query = "SELECT rc FROM ReleasedCourse rc " +
                "WHERE (:gpa >= 18 AND :totalCredits <= 24) " +
                "OR (:gpa < 18 AND :totalCredits <= 20)";

        return entityManger.createQuery(query, ReleasedCourse.class)
                .setParameter("gpa", gpa)
                .setParameter("totalCredits", totalCredits)
//                .setParameter("semester",semester)
                .getResultList();
    }

    @Override
    public Class<ReleasedCourse> getEntityClass() {
        return ReleasedCourse.class;
    }
}
