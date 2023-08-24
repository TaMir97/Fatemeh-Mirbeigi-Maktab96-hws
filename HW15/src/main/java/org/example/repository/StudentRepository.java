package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.domain.Student;

public interface StudentRepository extends BaseRepository<Student,Long> {
    public Student findByUsernameAndPassword(String username, String password);
}
