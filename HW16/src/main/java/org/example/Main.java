package org.example;

import org.example.domain.CardInfo;
import org.example.domain.EducationalInfo;
import org.example.domain.PersonalInfo;
import org.example.domain.Student;
import org.example.domain.enums.*;
import org.example.repository.StudentRepository;
import org.example.repository.impl.StudentRepoImpl;
import org.example.service.LoanAccountService;
import org.example.service.StudentService;
import org.example.ui.Menu;
import org.example.ui.menu.LoanAccountMenu;
import org.example.util.ApplicationContext;
import org.example.util.JsonFileReader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        Menu.run();
//        LoanAccountMenu.tuition();


    }
}