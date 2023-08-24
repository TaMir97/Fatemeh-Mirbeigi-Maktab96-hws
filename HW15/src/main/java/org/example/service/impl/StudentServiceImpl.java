package org.example.service.impl;

import org.example.base.service.BaseService;
import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.Department;
import org.example.domain.Employee;
import org.example.domain.Student;
import org.example.domain.StudentTakenCourse;
import org.example.domain.base.PersonId;
import org.example.domain.enums.StudentState;
import org.example.repository.StudentRepository;
import org.example.repository.StudentTakenCourseRepository;
import org.example.service.StudentService;
import org.example.service.StudentTakenCourseService;

public class StudentServiceImpl
        extends BaseServiceImpl<Student, Long, StudentRepository>
        implements StudentService {
    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }

    @Override
    public Student signIn(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }

    public Student signUp(String firstname, String lastname, String username, String password, String email, String departmentTitle) {
        PersonId personId = new PersonId();
        personId.setFirstname(firstname);
        personId.setLastname(lastname);
        personId.setUsername(username);
        personId.setPassword(password);
        personId.setEmail(email);

        Department studentDepartment = new Department();
        studentDepartment.setDepartmentName(departmentTitle);

        Student newStudent = new Student();
        newStudent.setPersonId(personId);
        newStudent.setStudentDepartment(studentDepartment);
        newStudent.setStudentState(StudentState.ENROLLED);
        return repository.save(newStudent);
    }



}
