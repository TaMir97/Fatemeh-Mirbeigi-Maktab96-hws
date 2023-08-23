package org.example.service.impl;

import org.example.base.service.BaseService;
import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.ReleasedCourse;
import org.example.domain.StudentTakenCourse;
import org.example.repository.ReleasedCourseRepository;
import org.example.repository.StudentTakenCourseRepository;
import org.example.service.ReleasedCourseService;
import org.example.service.StudentTakenCourseService;

public class ReleasedCourseServiceImpl
        extends BaseServiceImpl<ReleasedCourse, Long, ReleasedCourseRepository>
        implements ReleasedCourseService {
    public ReleasedCourseServiceImpl(ReleasedCourseRepository repository) {
        super(repository);
    }
}
