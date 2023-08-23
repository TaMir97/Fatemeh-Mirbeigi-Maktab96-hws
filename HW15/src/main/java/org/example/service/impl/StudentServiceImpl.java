package org.example.service.impl;

import org.example.base.service.BaseService;
import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.Student;
import org.example.domain.StudentTakenCourse;
import org.example.repository.StudentRepository;
import org.example.repository.StudentTakenCourseRepository;
import org.example.service.StudentService;
import org.example.service.StudentTakenCourseService;

public class StudentServiceImpl
        extends BaseServiceImpl<Student, Long, StudentRepository>
        implements StudentService {
    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }
}
