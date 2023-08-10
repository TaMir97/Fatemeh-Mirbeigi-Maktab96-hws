import ir.maktab.base.domain.Person;
import ir.maktab.base.repository.PersonRepo;
import ir.maktab.base.repository.PersonRepoImpl;
import ir.maktab.base.service.PersonService;
import ir.maktab.base.service.PersonServiceImpl;
import ir.maktab.domain.enumPack.AcademicRank;
import ir.maktab.domain.enumPack.Degree;
import ir.maktab.service.impl.StudentServiceImpl;
import ir.maktab.service.impl.TeacherServiceImpl;
import ir.maktab.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        PersonService<Person> personService = new PersonServiceImpl<>();
        System.out.println(personService.singUp("Tahoo", "Mir"));

        StudentServiceImpl studentService = new StudentServiceImpl();
        System.out.println(studentService.signUpStudent("Fa", "Mir",
                123L,"asd",
                "1402"));

        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        System.out.println(teacherService.signUpTeacher("Zaa", "asd",
                456L, Degree.ASSOCIATE, AcademicRank.ASSOCIATE_PROFESSOR,
                BigDecimal.valueOf(1500)));

    }
}
