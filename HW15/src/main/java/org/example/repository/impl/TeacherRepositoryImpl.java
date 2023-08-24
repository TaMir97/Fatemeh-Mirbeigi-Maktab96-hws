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
        CriteriaBuilder cb = entityManger.getCriteriaBuilder();
        CriteriaQuery<Teacher> query = cb.createQuery(Teacher.class);
        Root<Teacher> root = query.from(Teacher.class);

        Predicate usernamePredicate = cb.equal(root.get("username"), username);
        Predicate passwordPredicate = cb.equal(root.get("password"), password);

        query.select(root).where(cb.and(usernamePredicate, passwordPredicate));
        List<Teacher> resultList = entityManger.createQuery(query).getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    @Override
    public Teacher findByFirstnameAndLastname(String firstname, String lastname) {
        CriteriaBuilder cb = entityManger.getCriteriaBuilder();
        CriteriaQuery<Teacher> query = cb.createQuery(Teacher.class);
        Root<Teacher> root = query.from(Teacher.class);

        Predicate firstnamePredicate = cb.equal(root.get("firstname"), firstname);
        Predicate lastnamePredicate = cb.equal(root.get("lastname"), lastname);

        query.select(root).where(cb.and(firstnamePredicate, lastnamePredicate));
        List<Teacher> resultList = entityManger.createQuery(query).getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    @Override
    public Teacher findByEmail(String email) {
        CriteriaBuilder cb = entityManger.getCriteriaBuilder();
        CriteriaQuery<Teacher> query = cb.createQuery(Teacher.class);
        Root<Teacher> root = query.from(Teacher.class);

        Predicate emailPredicate = cb.equal(root.get("email"), email);

        query.select(root).where(emailPredicate);
        List<Teacher> resultList = entityManger.createQuery(query).getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    @Override
    public Class<Teacher> getEntityClass() {
        return Teacher.class;
    }


}
