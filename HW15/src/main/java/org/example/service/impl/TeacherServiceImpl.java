package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.Department;
import org.example.domain.Teacher;
import org.example.domain.enums.TeacherLevel;
import org.example.repository.TeacherRepository;
import org.example.service.TeacherService;

public class TeacherServiceImpl
        extends BaseServiceImpl<Teacher, Long, TeacherRepository>
        implements TeacherService {
    public TeacherServiceImpl(TeacherRepository repository) {
        super(repository);
    }

    public Teacher signIn(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }

    public Teacher signUp(String firstname, String lastname, String username, String password, String email,
                          Long baseSalary, TeacherLevel teacherLevel,
                          Department teacherDepartment) {

        if (repository.findByUsernameAndPassword(username, password) != null ||
                repository.findByFirstnameAndLastname(firstname, lastname) != null ||
                repository.findByEmail(email) != null) {
            Teacher newTeacher = new Teacher();
            newTeacher.setFirstname(firstname);
            newTeacher.setLastname(lastname);
            newTeacher.setUsername(username);
            newTeacher.setPassword(password);
            newTeacher.setEmail(email);
            newTeacher.setBaseSalary(baseSalary);
            newTeacher.setTeacherLevel(teacherLevel);
            newTeacher.setTeacherDepartment(teacherDepartment);

            return save(newTeacher);
        }
        return null;
    }
}
