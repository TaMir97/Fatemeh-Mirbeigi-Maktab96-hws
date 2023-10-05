package org.example.IOpractice.base.service;


import org.example.IOpractice.base.domain.BaseEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface BaseService<T extends BaseEntity<ID>,ID extends Serializable>{

    T save(T entity);
    T update(T entity);
    Optional<T> findById(ID id);
    void deleteById(ID id);
    Collection<T> showAll();
    long getCount();
    Collection<T> saveAll(Collection<T> entityCollection);
    boolean contain(T entity);
    boolean contain(ID id);

}
