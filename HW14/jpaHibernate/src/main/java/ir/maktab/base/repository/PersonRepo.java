package ir.maktab.base.repository;

import ir.maktab.base.domain.Person;
import ir.maktab.domain.Student;

import javax.persistence.EntityManager;
import java.util.Collection;

public interface PersonRepo<T extends Person> {
    T save(T person);

    void update(T person);

    void deleteById(Long id);

    Collection<T> loadAll(Class<T> clazz);

    boolean contains(T person);


    void beginTransaction();

    void commitTransaction();

    void rollBack();
    EntityManager getEntityManager();

}
