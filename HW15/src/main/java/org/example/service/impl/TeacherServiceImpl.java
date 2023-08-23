package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.Teacher;
import org.example.repository.TeacherRepository;
import org.example.service.TeacherService;

public class TeacherServiceImpl
        extends BaseServiceImpl<Teacher, Long, TeacherRepository>
        implements TeacherService {
    public TeacherServiceImpl(TeacherRepository repository) {
        super(repository);
    }
}
