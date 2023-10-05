package org.example.log4j.repository.impl;


import org.example.log4j.base.repository.PersonRepoImpl;
import org.example.log4j.domain.Teacher;
import org.example.log4j.repository.TeacherRepo;

import javax.persistence.EntityManager;

public class TeacherRepoImpl extends PersonRepoImpl<Teacher> implements TeacherRepo {
    public TeacherRepoImpl(EntityManager em) {
        super(em);
    }
}
