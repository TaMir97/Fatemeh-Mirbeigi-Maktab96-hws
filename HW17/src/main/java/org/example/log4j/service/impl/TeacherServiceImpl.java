package org.example.log4j.service.impl;


import org.example.log4j.base.service.PersonServiceImpl;
import org.example.log4j.domain.Teacher;
import org.example.log4j.repository.TeacherRepo;
import org.example.log4j.repository.impl.StudentRepoImpl;
import org.example.log4j.repository.impl.TeacherRepoImpl;
import org.example.log4j.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.logging.Logger;

public class TeacherServiceImpl extends PersonServiceImpl<Teacher> {
    EntityManager entityManager = HibernateUtil.getEntityManager();
    private final TeacherRepo teacherRepo = new TeacherRepoImpl(entityManager);
    private static final Logger logger = Logger.getLogger(StudentRepoImpl.class.getName());


    public Teacher signUpTeacher(String firstname, String lastname,
                                 Long teacherNo, String degree, String academicRank,
                                 BigDecimal payment) {
        logger.info("Teacher saved.");
        Teacher teacher = new Teacher();
        teacher.setFirstname(firstname);
        teacher.setLastname(lastname);
        teacher.setTeacherNo(teacherNo);
        teacher.setDegree(degree);
        teacher.setAcademicRank(academicRank);
        teacher.setPayment(payment);
        entityManager.clear();
        teacherRepo.beginTransaction();
        Teacher saved = teacherRepo.save(teacher);
        teacherRepo.commitTransaction();
        return saved;
    }
}
