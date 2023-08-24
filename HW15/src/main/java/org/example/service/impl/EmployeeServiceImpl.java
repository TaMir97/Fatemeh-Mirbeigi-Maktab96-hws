package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.Employee;
import org.example.repository.EmployeeRepository;
import org.example.service.EmployeeService;

public class EmployeeServiceImpl
        extends BaseServiceImpl<Employee, Long, EmployeeRepository>
        implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }

    @Override
    public Employee signIn(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }

    public Employee signUp(String firstname, String lastname, String username, String password, String email, Long salary) {
        if (repository.findByUsernameAndPassword(username, password) != null ||
                repository.findByFirstnameAndLastname(firstname, lastname) != null ||
                repository.findByEmail(email) != null) {
            Employee newEmployee = new Employee();
            newEmployee.setFirstname(firstname);
            newEmployee.setLastname(lastname);
            newEmployee.setUsername(username);
            newEmployee.setPassword(password);
            newEmployee.setEmail(email);

            newEmployee.setSalary(salary);


            return save(newEmployee);
        }
        return null;
    }
}
