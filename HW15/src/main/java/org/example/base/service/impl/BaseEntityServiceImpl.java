package org.example.base.service.impl;

import org.example.base.domain.BaseEntity;
import org.example.base.repository.BaseEntityRepository;
import org.example.base.service.BaseEntityService;

import java.io.Serializable;
import java.util.Collection;

public class BaseEntityServiceImpl <T extends BaseEntity<ID>,
        ID extends Serializable, R extends BaseEntityRepository<T,ID>>
        implements BaseEntityService<T,ID>
{

    private final R repository;

    public BaseEntityServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        if (!repository.contains(entity)) {

            try {
                repository.beginTransaction();
                repository.save(entity);
                repository.commitTransaction();
            } catch (Exception e) {
                repository.rollBack();
                return null;
            }

        } else {
            throw new RuntimeException("This entity is already saved");
        }
        return entity;

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void deleteById(ID id) {

    }

    @Override
    public T findById(ID id) {
        return null;
    }

    @Override
    public boolean contains(T entity) {
        return false;
    }

    @Override
    public Collection<T> findAll() {
        return null;
    }

    @Override
    public long getCount() {
        return 0;
    }

    @Override
    public Collection<T> saveAll(Collection<T> entityCollection) {
        return null;
    }

    @Override
    public void beginTransaction() {

    }

    @Override
    public void commitTransaction() {

    }

    @Override
    public void rollBack() {

    }
}
