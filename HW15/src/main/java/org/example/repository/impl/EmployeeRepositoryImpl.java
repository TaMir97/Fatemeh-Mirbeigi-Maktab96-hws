package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.SemesterRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeRepositoryImpl extends
        BaseRepositoryImpl<Employee,Long>
        implements EmployeeRepository {
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public Employee findByUsernameAndPassword(String username, String password) {
        TypedQuery<Employee> query = entityManger.createQuery(
                "SELECT t FROM Teacher t WHERE t.username = :username AND t.password = :password",
                Employee.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public Employee findByFirstnameAndLastname(String firstname, String lastname) {
        TypedQuery<Employee> query = entityManger.createQuery(
                "SELECT t FROM Teacher t WHERE t.firstname = :firstname AND t.lastname = :lastname",
                Employee.class);
        query.setParameter("firstname", firstname);
        query.setParameter("lastname", lastname);
        return query.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public Employee findByEmail(String email) {
        TypedQuery<Employee> query = entityManger.createQuery(
                "SELECT t FROM Teacher t WHERE t.email = :email",
                Employee.class);
        query.setParameter("email", email);
        return query.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
