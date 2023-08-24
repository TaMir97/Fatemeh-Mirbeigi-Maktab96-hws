package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.domain.Employee;

public interface EmployeeRepository extends BaseRepository<Employee,Long> {
    Employee findByUsernameAndPassword(String username, String password);
}
