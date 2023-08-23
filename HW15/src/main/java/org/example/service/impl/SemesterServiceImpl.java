package org.example.service.impl;

import org.example.base.service.BaseService;
import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.Semester;
import org.example.domain.StudentTakenCourse;
import org.example.repository.SemesterRepository;
import org.example.repository.StudentTakenCourseRepository;
import org.example.service.SemesterService;
import org.example.service.StudentTakenCourseService;

public class SemesterServiceImpl
        extends BaseServiceImpl<Semester, Long, SemesterRepository>
        implements SemesterService {
    public SemesterServiceImpl(SemesterRepository repository) {
        super(repository);
    }
}
