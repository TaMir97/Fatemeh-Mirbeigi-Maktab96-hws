package org.example.log4j.base.repository;

import org.example.log4j.base.domain.Person;

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
