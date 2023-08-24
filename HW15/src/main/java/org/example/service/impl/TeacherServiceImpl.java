package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.Department;
import org.example.domain.ReleasedCourse;
import org.example.domain.Teacher;
import org.example.domain.base.PersonId;
import org.example.domain.enums.TeacherLevel;
import org.example.repository.TeacherRepository;
import org.example.service.TeacherService;

import java.util.List;

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
        PersonId personId = new PersonId();
        personId.setFirstname(firstname);
        personId.setLastname(lastname);
        personId.setUsername(username);
        personId.setPassword(password);
        personId.setEmail(email);

        Teacher newTeacher = new Teacher();
        newTeacher.setPersonId(personId);
        newTeacher.setBaseSalary(baseSalary);
        newTeacher.setTeacherLevel(teacherLevel);
        newTeacher.setTeacherDepartment(teacherDepartment);

        return repository.save(newTeacher);
    }
}
