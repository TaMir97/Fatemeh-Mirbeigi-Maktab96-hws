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
        MainMenu.run();
    }
}
