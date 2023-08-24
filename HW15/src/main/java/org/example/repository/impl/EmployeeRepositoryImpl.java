package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.domain.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.SemesterRepository;

import javax.persistence.EntityManager;
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

    public Employee findByUsernameAndPassword(String username, String password) {
        CriteriaBuilder criteriaBuilder = entityManger.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

        Predicate usernamePredicate = criteriaBuilder.equal(employeeRoot.get("personId").get("username"), username);
        Predicate passwordPredicate = criteriaBuilder.equal(employeeRoot.get("personId").get("password"), password);
        Predicate combinedPredicate = criteriaBuilder.and(usernamePredicate, passwordPredicate);

        criteriaQuery.where(combinedPredicate);

        List<Employee> foundEmployees = entityManger.createQuery(criteriaQuery).getResultList();

        if (!foundEmployees.isEmpty()) {
            return foundEmployees.get(0);
        }

        return null;
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
