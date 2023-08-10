package ir.maktab.repository.impl;

import ir.maktab.base.repository.PersonRepoImpl;
import ir.maktab.domain.Student;
import ir.maktab.repository.StudentRepo;

import javax.persistence.EntityManager;

public class StudentRepoImpl extends PersonRepoImpl<Student> implements StudentRepo {
    private final EntityManager entityManager;
    public StudentRepoImpl(EntityManager em) {
        super(em);
        entityManager = em;
    }

    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

}
