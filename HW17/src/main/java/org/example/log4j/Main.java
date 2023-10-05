package org.example.log4j;

import org.example.log4j.base.domain.Person;
import org.example.log4j.base.service.PersonService;
import org.example.log4j.base.service.PersonServiceImpl;
import org.example.log4j.domain.enumPack.AcademicRank;
import org.example.log4j.domain.enumPack.Degree;
import org.example.log4j.service.impl.StudentServiceImpl;
import org.example.log4j.service.impl.TeacherServiceImpl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger("");
        FileHandler fileHandler = new FileHandler("output.log", true);
        logger.addHandler(fileHandler);
        logger.setLevel(Level.ALL);


        PersonService<Person> personService = new PersonServiceImpl<>();
        System.out.println(personService.singUp("Tahoo", "Mir"));

        StudentServiceImpl studentService = new StudentServiceImpl();
        System.out.println(studentService.signUpStudent("Fa", "Mir",
                123L,"asd",
                "1402"));

        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        System.out.println(teacherService.signUpTeacher("Zaa", "asd",
                456L, Degree.ASSOCIATE.toString(), AcademicRank.ASSOCIATE_PROFESSOR.toString(),
                BigDecimal.valueOf(1500)));
    }
}