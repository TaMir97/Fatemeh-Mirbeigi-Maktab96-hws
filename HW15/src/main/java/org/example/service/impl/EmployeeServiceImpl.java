package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.Employee;
import org.example.domain.base.PersonId;
import org.example.domain.enums.Role;
import org.example.repository.EmployeeRepository;
import org.example.service.EmployeeService;

public class EmployeeServiceImpl
        extends BaseServiceImpl<Employee, Long, EmployeeRepository>
        implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }

    public Employee signUp(String firstname, String lastname, String username, String password, String email, Long salary) {
        PersonId personId = new PersonId();
        personId.setFirstname(firstname);
        personId.setLastname(lastname);
        personId.setUsername(username);
        personId.setPassword(password);
        personId.setEmail(email);

        Employee newEmployee = new Employee();
        newEmployee.setPersonId(personId);
        newEmployee.setSalary(salary);

        return repository.save(newEmployee);
    }

    @Override
    public Employee signIn(String username, String password) {
        return repository.findByUsernameAndPassword(username,password);
    }
}
