package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.EducationalInfo;
import org.example.domain.PersonalInfo;
import org.example.domain.Student;
import org.example.domain.enums.*;
import org.example.repository.StudentRepository;
import org.example.service.StudentService;

import java.time.LocalDate;

public class StudentServiceImpl
        extends BaseServiceImpl<Student, Long, StudentRepository>
        implements StudentService {
    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }

    @Override
    public Student signUp(String firstname, String lastname, Gender gender, String fatherName, String motherName, Long birthCN, Long birthId, String birthdate, String city, MarriageState marriageState, Long spouseId, Long studentId, String uniName, UniversityType universityType, GovernmentUniversity governmentUniversity, Integer startedYear, EducationalGrade educationalGrade, String uniCity, Boolean isGraduate) {
        Student newStudent = new Student();
        newStudent.setFirstname(firstname);
        newStudent.setLastname(lastname);
        newStudent.setGender(gender);
        newStudent.setFatherName(fatherName);
        newStudent.setMotherName(motherName);
        newStudent.setBirthCertificateNumber(birthCN);
        newStudent.setBirthCertificateId(birthId);
        newStudent.setBirthdate(birthdate);
        newStudent.setHomeCity(city);
        newStudent.setMarriageState(marriageState);
        newStudent.setSpouseBirthCertificateId(spouseId);
        newStudent.setStudentId(studentId);
        newStudent.setUniversityName(uniName);
        newStudent.setUniversityType(universityType);
        newStudent.setGovernmentUniversityType(governmentUniversity);
        newStudent.setStartedYear(startedYear);
        newStudent.setGrade(educationalGrade);
        newStudent.setCity(uniCity);
        newStudent.setGraduated(isGraduate);
        return repository.save(newStudent);
    }
}
