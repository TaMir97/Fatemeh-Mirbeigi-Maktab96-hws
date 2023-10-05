package org.example.log4j.service.impl;



import org.example.log4j.base.service.PersonServiceImpl;
import org.example.log4j.domain.Stud3nt;
import org.example.log4j.repository.StudentRepo;
import org.example.log4j.repository.impl.StudentRepoImpl;
import org.example.log4j.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.logging.Logger;

public class StudentServiceImpl extends PersonServiceImpl<Stud3nt> {

    EntityManager entityManager = HibernateUtil.getEntityManager();
    private static final Logger logger = Logger.getLogger(StudentRepoImpl.class.getName());
    private final StudentRepo studentRepo = new StudentRepoImpl(entityManager);


    public Stud3nt signUpStudent(String firstname, String lastname, Long studentNo, String studyField, String startedYear) {
        logger.info("Student Saved.");
        Stud3nt student = new Stud3nt();
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setStudentNo(studentNo);
        student.setStudyField(studyField);
        student.setStartedYear(startedYear);
        entityManager.clear();
        studentRepo.beginTransaction();
        Stud3nt saved = studentRepo.save(student);
        studentRepo.commitTransaction();
        return saved;
    }

}
