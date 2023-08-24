package org.example.service;

import org.example.base.service.BaseService;
import org.example.domain.Employee;
import org.example.domain.Student;

import java.util.List;

public interface StudentService extends BaseService<Student,Long> {
    Student signIn(String username, String password);
    Student signUp(String firstname, String lastname, String username, String password, String email, String departmentTitle);
    List<Student> studentsWithHighGPA();
    List<Student> studentsWithLowGPA();
}
