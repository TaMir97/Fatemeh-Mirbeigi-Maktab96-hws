package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.domain.Student;

import java.util.List;

public interface StudentRepository extends BaseRepository<Student,Long> {
    Student findByUsernameAndPassword(String username, String password);
    Student findByFirstnameAndLastname(String firstname, String lastname);
    Student findByEmail(String email);
    List<Student> studentsWithHighGPA();
    List<Student> studentsWithLowGPA();
}
