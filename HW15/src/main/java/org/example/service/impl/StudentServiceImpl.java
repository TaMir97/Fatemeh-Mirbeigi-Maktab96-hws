package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.Department;
import org.example.domain.Student;
import org.example.domain.enums.StudentState;
import org.example.repository.StudentRepository;
import org.example.service.StudentService;

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

    public Student signUp(String firstname,
                          String lastname,
                          String username,
                          String password,
                          String email,
                          String departmentTitle) {
        if (repository.findByUsernameAndPassword(username, password) != null ||
                repository.findByFirstnameAndLastname(firstname, lastname) != null ||
                repository.findByEmail(email) != null) {
            Student newStudent = new Student();
            newStudent.setFirstname(firstname);
            newStudent.setLastname(lastname);
            newStudent.setUsername(username);
            newStudent.setPassword(password);
            newStudent.setEmail(email);

            Department studentDepartment = new Department();
            studentDepartment.setDepartmentName(departmentTitle);

            newStudent.setStudentDepartment(studentDepartment);
            newStudent.setStudentState(StudentState.ENROLLED);
            return save(newStudent);
        }
        return null;
    }
}



}
