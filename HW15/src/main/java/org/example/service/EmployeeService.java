package org.example.service;

import org.example.base.service.BaseService;
import org.example.domain.Employee;

public interface EmployeeService extends BaseService<Employee,Long> {
    Employee signIn(String username, String password);
    Employee signUp(String firstname, String lastname, String username, String password, String email, Long salary);

}
