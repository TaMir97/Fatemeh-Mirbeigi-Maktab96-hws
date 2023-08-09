package ir.maktab.base.repository;

import ir.maktab.base.domain.Person;

import java.util.Collection;

public interface PersonRepo {
    Person save(Person person);

    void update(Person person);

    void deleteById(Long id);

    Collection<Person> loadAll();

    boolean contains(Person person);


    Collection<Person> saveAll(Collection<Person> persons);

    void beginTransaction();

    void commitTransaction();

    void rollBack();

}
