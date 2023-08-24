package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.Teacher;
import org.example.repository.TeacherRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class TeacherRepositoryImpl
        extends BaseRepositoryImpl<Teacher,Long>
        implements TeacherRepository {

    public TeacherRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    public Teacher findByUsernameAndPassword(String username, String password) {
        CriteriaBuilder criteriaBuilder = entityManger.getCriteriaBuilder();
        CriteriaQuery<Teacher> criteriaQuery = criteriaBuilder.createQuery(Teacher.class);
        Root<Teacher> teacherRoot = criteriaQuery.from(Teacher.class);

        Predicate usernamePredicate = criteriaBuilder.equal(teacherRoot.get("personId").get("username"), username);
        Predicate passwordPredicate = criteriaBuilder.equal(teacherRoot.get("personId").get("password"), password);
        Predicate combinedPredicate = criteriaBuilder.and(usernamePredicate, passwordPredicate);

        criteriaQuery.where(combinedPredicate);

        List<Teacher> foundTeachers = entityManger.createQuery(criteriaQuery).getResultList();

        if (!foundTeachers.isEmpty()) {
            return foundTeachers.get(0);
        }
        return null;
    }

    @Override
    public Class<Teacher> getEntityClass() {
        return Teacher.class;
    }


}
