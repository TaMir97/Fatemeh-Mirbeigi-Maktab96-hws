package org.example.service.impl;

import org.example.base.service.BaseService;
import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.ReleasedCourse;
import org.example.domain.Student;
import org.example.domain.StudentTakenCourse;
import org.example.domain.Teacher;
import org.example.repository.StudentTakenCourseRepository;
import org.example.repository.TeacherRepository;
import org.example.service.StudentTakenCourseService;
import org.example.service.TeacherService;

import java.util.List;

public class StudentTakenCourseServiceImpl
        extends BaseServiceImpl<StudentTakenCourse, Long, StudentTakenCourseRepository>
        implements StudentTakenCourseService {
    public StudentTakenCourseServiceImpl(StudentTakenCourseRepository repository) {
        super(repository);
    }

    @Override
    public StudentTakenCourse addCourseByGpa(Student student, ReleasedCourse releasedCourse) {
        try {
            repository.beginTransaction();
            repository.addCourseByGpa(student, releasedCourse);
            repository.commitTransaction();
            return repository.addCourseByGpa(student, releasedCourse);
        }catch (Exception e){
            repository.rollBack();
            System.out.println(e.getMessage());
            return null;
        }

    }
}
