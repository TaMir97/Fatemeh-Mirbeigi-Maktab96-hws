package org.example.base.service.impl;

import org.example.base.domain.BaseEntity;
import org.example.base.repository.BaseRepository;
import org.example.base.service.BaseService;
import org.example.validation.EntityValidator;

import javax.validation.ConstraintViolation;
import java.io.Serializable;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;

public class BaseServiceImpl
        <T extends BaseEntity<ID>,
                ID extends Serializable,
                R extends BaseRepository<T, ID>>
        implements BaseService<T, ID> {


    protected final R repository;
    private final Validator entityValidator;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
        this.entityValidator = EntityValidator.validator;
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

        } else {
            throw new RuntimeException("This entity is already saved");
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

        } else {
            throw new RuntimeException("This entity is not saved");
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
    public boolean isValid(T t) {
        Set<ConstraintViolation<T>> violations = entityValidator.validate(t);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<T> p : violations)
                System.out.println(p.getMessage());
            return false;
        }
        return true;
    }

}
