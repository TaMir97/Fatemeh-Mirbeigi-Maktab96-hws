package ir.maktab.repository;

import ir.maktab.base.domain.Person;
import ir.maktab.base.repository.PersonRepo;
import ir.maktab.domain.Student;

import javax.persistence.Column;
import java.util.Collection;

public interface StudentRepo extends PersonRepo<Student> {
    @Override
    Student save(Student person);
}
