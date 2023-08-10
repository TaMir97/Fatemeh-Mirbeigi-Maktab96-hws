package ir.maktab.service.impl;

import ir.maktab.base.service.PersonServiceImpl;
import ir.maktab.domain.Teacher;
import ir.maktab.domain.enumPack.AcademicRank;
import ir.maktab.domain.enumPack.Degree;
import ir.maktab.repository.TeacherRepo;
import ir.maktab.repository.impl.TeacherRepoImpl;
import ir.maktab.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;

public class TeacherServiceImpl extends PersonServiceImpl<Teacher>{
    EntityManager entityManager = HibernateUtil.getEntityManager();
    private final TeacherRepo teacherRepo = new TeacherRepoImpl(entityManager);


    public Teacher signUpTeacher(String firstname, String lastname,
                                 Long teacherNo, String degree, String academicRank,
                                 BigDecimal payment) {
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
