package ir.maktab.base.repository;

import ir.maktab.base.domain.Person;

import java.util.Collection;
import java.util.Optional;

public interface PersonRepo<T extends Person> {
    T saveOrUpdate(T entity);

    void deleteById(Long id);

    Collection<T> loadAll();

    boolean contains(T entity);


    Collection<T> saveAll(Collection<T> persons);

    void beginTransaction();

    void commitTransaction();

    void rollBack();

}
