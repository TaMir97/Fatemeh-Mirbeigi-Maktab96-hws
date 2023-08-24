package org.example.service;

import org.example.base.service.BaseService;
import org.example.domain.Department;
import org.example.domain.ReleasedCourse;
import org.example.domain.Teacher;
import org.example.domain.enums.TeacherLevel;

import java.util.List;

public interface TeacherService extends BaseService<Teacher,Long> {
    Teacher signIn(String username, String password);

    Teacher signUp(String firstname, String lastname, String username, String password, String email,
                          Long baseSalary, TeacherLevel teacherLevel,
                          Department teacherDepartment);
}
