package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.Student;
import org.example.repository.StudentRepository;
import org.example.service.StudentService;

public class StudentServiceImpl
        extends BaseServiceImpl<Student, Long, StudentRepository>
        implements StudentService {
    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }
}
