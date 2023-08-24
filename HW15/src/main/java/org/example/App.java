package org.example;

import org.example.domain.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.impl.EmployeeRepositoryImpl;
import org.example.service.EmployeeService;
import org.example.service.impl.EmployeeServiceImpl;
import org.example.ui.menu.MainMenu;
import org.example.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(entityManager);
//        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository);
//
//        Employee employee = new Employee();
//        employee.setFirstname("Tahoora");
//        employee.setLastname("Mirbeigi");
//        employee.setUsername("9913731020");
//        employee.setPassword("12345t");
//        employee.setEmail("tahoora_m@yahoo.com");
//        employee.setSalary(10000000L);
//
//        employeeRepository.beginTransaction();
//        employeeService.save(employee);
//        employeeRepository.commitTransaction();

        MainMenu.run();
    }
}
