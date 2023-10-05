package org.example.IOpractice.base.service.impl;


import org.example.IOpractice.base.domain.BaseEntity;
import org.example.IOpractice.base.repository.BaseRepository;
import org.example.IOpractice.base.service.BaseService;

import java.io.Serializable;
import java.util.*;

public class BaseServiceImpl
        <T extends BaseEntity<ID>,
                ID extends Serializable,
                R extends BaseRepository<T, ID>>
        implements BaseService<T, ID> {


    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        if (!repository.contain(entity)) {
            try {
                repository.beginTransaction();
                repository.save(entity);
                repository.commitTransaction();
            } catch (Exception e) {
                repository.rollBack();
                return null;
            }

        }
        return entity;
    }


    @Override
    public T update(T entity) {
        if (repository.contain(entity)) {
            try {
                repository.beginTransaction();
                repository.update(entity);
                repository.commitTransaction();
            } catch (Exception e) {
                repository.rollBack();
                return entity;
            }

        }
        return null;
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(ID id) {
        if (repository.contain(id)) {
            try {
                repository.beginTransaction();
                repository.deleteById(id);
                repository.commitTransaction();
            } catch (Exception e) {
                repository.rollBack();
            }

        }
    }


    @Override
    public Collection<T> showAll() {
        return repository.showAll();
    }

    @Override
    public long getCount() {
        return repository.getCount();
    }

    @Override
    public Collection<T> saveAll(Collection<T> entityCollection) {
        List<T> saveList = new ArrayList<>();
        entityCollection.forEach(entity -> saveList.add(save(entity)));
        return saveList;
    }


    @Override
    public boolean contain(T entity) {
        return repository.contain(entity) ;
    }

    @Override
    public boolean contain(ID id) {
        return repository.contain(id);
    }

}