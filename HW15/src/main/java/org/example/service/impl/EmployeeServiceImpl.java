package org.example.service.impl;

import org.example.base.service.BaseService;
import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.Employee;
import org.example.domain.StudentTakenCourse;
import org.example.repository.EmployeeRepository;
import org.example.repository.StudentTakenCourseRepository;
import org.example.service.EmployeeService;
import org.example.service.StudentTakenCourseService;

public class EmployeeServiceImpl
        extends BaseServiceImpl<Employee, Long, EmployeeRepository>
        implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }
}
