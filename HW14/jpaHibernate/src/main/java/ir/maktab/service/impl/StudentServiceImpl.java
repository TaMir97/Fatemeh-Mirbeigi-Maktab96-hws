package ir.maktab.service.impl;


import ir.maktab.base.service.PersonServiceImpl;
import ir.maktab.domain.Student;
import ir.maktab.repository.StudentRepo;
import ir.maktab.repository.impl.StudentRepoImpl;
import ir.maktab.util.HibernateUtil;

import javax.persistence.EntityManager;

public class StudentServiceImpl extends PersonServiceImpl<Student>{

    EntityManager entityManager = HibernateUtil.getEntityManager();
    private final StudentRepo studentRepo = new StudentRepoImpl(entityManager);


    public Student signUpStudent(String firstname, String lastname, Long studentNo, String studyField, String startedYear) {
        Student student = new Student();
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setStudentNo(studentNo);
        student.setStudyField(studyField);
        student.setStartedYear(startedYear);
        entityManager.clear();
        studentRepo.beginTransaction();
        Student saved = studentRepo.save(student);
        studentRepo.commitTransaction();
        return saved;
    }

}
