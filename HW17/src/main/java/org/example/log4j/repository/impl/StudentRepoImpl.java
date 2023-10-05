package org.example.log4j.repository.impl;


import org.example.log4j.base.repository.PersonRepoImpl;
import org.example.log4j.domain.Stud3nt;
import org.example.log4j.repository.StudentRepo;

import javax.persistence.EntityManager;
import java.util.logging.Logger;

public class StudentRepoImpl extends PersonRepoImpl<Stud3nt> implements StudentRepo {
    private final EntityManager entityManager;
    private static final Logger logger = Logger.getLogger(StudentRepoImpl.class.getName());
    public StudentRepoImpl(EntityManager em) {
        super(em);
        entityManager = em;
    }

    public Stud3nt save(Stud3nt student) {
        try {
            entityManager.persist(student);
            logger.info("Saved student with ID: " + student.getPersonId());
        } catch (Exception e) {
            logger.warning("Student couldn't be saved");
        }
        return student;
    }

}
