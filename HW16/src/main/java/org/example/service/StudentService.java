package org.example.service;

import org.example.base.service.BaseService;
import org.example.domain.EducationalInfo;
import org.example.domain.PersonalInfo;
import org.example.domain.Student;
import org.example.domain.enums.*;

import java.time.LocalDate;

public interface StudentService extends BaseService<Student,Long> {
    Student signUp(String firstname,
                   String lastname,
                   Gender gender,
                   String fatherName,
                   String motherName,
                   Long birthCN,
                   Long BirthId,
                   String birthdate,
                   String city,
                   MarriageState marriageState,
                   Long spouseId,
                   Long studentId,
                   String uniName,
                   UniversityType universityType,
                   GovernmentUniversity governmentUniversity,
                   Integer startedYear,
                   EducationalGrade educationalGrade,
                   String uniCity,
                   Boolean isGraduate);
}
