package org.example.util;

import org.example.repository.*;
import org.example.repository.impl.*;
import org.example.service.*;
import org.example.service.impl.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory emf;
    private static final EntityManager em;
    private static final CourseRepository COURSE_REPOSITORY;
    private static final CourseService COURSE_SERVICE;
    private static final EmployeeRepository EMPLOYEE_REPOSITORY;
    private static final EmployeeService EMPLOYEE_SERVICE;
    private static final TeacherRepository TEACHER_REPOSITORY;
    private static final TeacherService TEACHER_SERVICE;
    private static final StudentRepository STUDENT_REPOSITORY;
    private static final StudentService STUDENT_SERVICE;
    private static final DepartmentService DEPARTMENT_SERVICE;
    private static final DepartmentRepository DEPARTMENT_REPOSITORY;
    private static final SemesterRepository SEMESTER_REPOSITORY;
    private static final SemesterService SEMESTER_SERVICE;
    private static final ReleasedCourseRepository RELEASED_COURSE_REPOSITORY;
    private static final ReleasedCourseService RELEASED_COURSE_SERVICE;
    private static final StudentTakenCourseRepository STUDENT_TAKEN_COURSE_REPOSITORY;
    private static final StudentTakenCourseService STUDENT_TAKEN_COURSE_SERVICE;


    static {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        COURSE_REPOSITORY = new CourseRepositoryImpl(em);
        COURSE_SERVICE = new CourseServiceImpl(COURSE_REPOSITORY);
        EMPLOYEE_REPOSITORY = new EmployeeRepositoryImpl(em);
        EMPLOYEE_SERVICE = new EmployeeServiceImpl(EMPLOYEE_REPOSITORY);
        TEACHER_REPOSITORY = new TeacherRepositoryImpl(em);
        TEACHER_SERVICE = new TeacherServiceImpl(TEACHER_REPOSITORY);
        STUDENT_REPOSITORY = new StudentRepositoryImpl(em);
        STUDENT_SERVICE = new StudentServiceImpl(STUDENT_REPOSITORY);
        DEPARTMENT_REPOSITORY = new DepartmentRepositoryImpl(em);
        DEPARTMENT_SERVICE = new DepartmentServiceImpl(DEPARTMENT_REPOSITORY);
        SEMESTER_REPOSITORY = new SemesterRepositoryImpl(em);
        SEMESTER_SERVICE = new SemesterServiceImpl(SEMESTER_REPOSITORY);
        RELEASED_COURSE_REPOSITORY = new ReleasedCourseRepositoryImpl(em);
        RELEASED_COURSE_SERVICE = new ReleasedCourseServiceImpl(RELEASED_COURSE_REPOSITORY);
        STUDENT_TAKEN_COURSE_REPOSITORY = new StudentTakenCourseRepositoryImpl(em);
        STUDENT_TAKEN_COURSE_SERVICE = new StudentTakenCourseServiceImpl(STUDENT_TAKEN_COURSE_REPOSITORY);
    }

    public static CourseService getCourseService() {
        return COURSE_SERVICE;
    }

    public static EmployeeService getEmployeeService() {
        return EMPLOYEE_SERVICE;
    }

    public static TeacherService getTeacherService() {
        return TEACHER_SERVICE;
    }

    public static StudentService getStudentService() {
        return STUDENT_SERVICE;
    }

    public static DepartmentService getDepartmentService() {
        return DEPARTMENT_SERVICE;
    }

    public static SemesterService getSemesterService() {
        return SEMESTER_SERVICE;
    }

    public static ReleasedCourseService getReleasedCourseService() {
        return RELEASED_COURSE_SERVICE;
    }

    public static StudentTakenCourseService getStudentTakenCourseService() {
        return STUDENT_TAKEN_COURSE_SERVICE;
    }
}