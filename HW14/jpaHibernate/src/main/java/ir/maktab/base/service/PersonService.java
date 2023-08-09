package ir.maktab.base.service;

import ir.maktab.base.domain.Person;

import java.util.Collection;

public interface PersonService {
    Person singUp(String firstname, String lastname);

    void update(Person person);

    void deleteById(Long id);

    Collection<Person> loadAll();

    boolean contains(Person person);


    Collection<Person> saveAll(Collection<Person> people);

    void beginTransaction();

    void commitTransaction();

    void rollBack();
}
