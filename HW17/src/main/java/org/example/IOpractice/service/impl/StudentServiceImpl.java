package org.example.IOpractice.service.impl;

import org.example.IOpractice.base.service.impl.BaseServiceImpl;
import org.example.IOpractice.domain.Student;
import org.example.IOpractice.repository.StudentRepository;
import org.example.IOpractice.service.StudentService;

public class StudentServiceImpl
        extends BaseServiceImpl<Student, Long, StudentRepository>
        implements StudentService {
    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }
}
