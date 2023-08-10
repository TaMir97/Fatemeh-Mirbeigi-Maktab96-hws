package ir.maktab.repository.impl;

import ir.maktab.base.repository.PersonRepoImpl;
import ir.maktab.domain.Teacher;
import ir.maktab.repository.StudentRepo;
import ir.maktab.repository.TeacherRepo;

import javax.persistence.EntityManager;

public class TeacherRepoImpl extends PersonRepoImpl<Teacher> implements TeacherRepo {
    public TeacherRepoImpl(EntityManager em) {
        super(em);
    }
}
