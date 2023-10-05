package org.example.log4j.base.service;


import org.example.log4j.base.domain.Person;

import java.util.Collection;

public interface PersonService<T extends Person> {
    T singUp(String firstname, String lastname);

    void update(T person);

    void deleteById(Long id);

    Collection<T> loadAll(Class<T> clazz);

    boolean contains(T person);


    void beginTransaction();

    void commitTransaction();

    void rollBack();
}
