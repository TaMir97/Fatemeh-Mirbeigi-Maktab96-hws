package org.example.service;

import org.example.base.service.BaseService;
import org.example.domain.ReleasedCourse;
import org.example.domain.Student;
import org.example.domain.StudentTakenCourse;

import java.util.List;

public interface StudentTakenCourseService extends BaseService<StudentTakenCourse,Long> {
    StudentTakenCourse addCourseByGpa(Student student, ReleasedCourse releasedCourse);
}
