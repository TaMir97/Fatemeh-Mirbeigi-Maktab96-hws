package org.example.IOpractice.service.impl;

import org.example.IOpractice.base.service.impl.BaseServiceImpl;
import org.example.IOpractice.domain.Course;
import org.example.IOpractice.repository.CourseRepository;
import org.example.IOpractice.service.CourseService;

public class CourseServiceImpl
        extends BaseServiceImpl<Course, Long, CourseRepository>
        implements CourseService {
    public CourseServiceImpl(CourseRepository repository) {
        super(repository);
    }
}
