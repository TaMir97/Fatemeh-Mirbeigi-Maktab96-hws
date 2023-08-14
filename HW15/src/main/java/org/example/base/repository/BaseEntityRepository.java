package org.example.base.repository;

import org.example.base.domain.BaseEntity;

import java.io.Serializable;
import java.util.Collection;

public interface BaseEntityRepository<T extends BaseEntity<ID>, ID extends Serializable> {

    T save(T entity);

    void update(T entity);

    void deleteById(ID id);

    T findById(ID id);

    boolean contains(T entity);

    Collection<T> findAll();

    long getCount();

    Collection<T> saveAll(Collection<T> entityCollection);

    void beginTransaction();

    void commitTransaction();

    void rollBack();

}
