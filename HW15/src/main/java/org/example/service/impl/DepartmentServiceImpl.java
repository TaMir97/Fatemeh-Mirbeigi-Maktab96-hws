package org.example.service.impl;

import org.example.base.service.BaseService;
import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.Department;
import org.example.domain.StudentTakenCourse;
import org.example.repository.DepartmentRepository;
import org.example.repository.StudentTakenCourseRepository;
import org.example.service.DepartmentService;
import org.example.service.StudentTakenCourseService;

public class DepartmentServiceImpl
        extends BaseServiceImpl<Department, Long, DepartmentRepository>
        implements DepartmentService {
    public DepartmentServiceImpl(DepartmentRepository repository) {
        super(repository);
    }
}
