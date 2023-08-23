package org.example.service.impl;

import org.example.base.service.BaseService;
import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.Course;
import org.example.domain.StudentTakenCourse;
import org.example.repository.CourseRepository;
import org.example.repository.StudentTakenCourseRepository;
import org.example.service.CourseService;
import org.example.service.StudentTakenCourseService;

public class CourseServiceImpl
        extends BaseServiceImpl<Course, Long, CourseRepository>
        implements CourseService {
    public CourseServiceImpl(CourseRepository repository) {
        super(repository);
    }
}
