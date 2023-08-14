package org.example.base.repository;

import org.example.base.domain.BaseEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseEntityRepositoryImpl<T extends BaseEntity<ID>, ID extends Serializable>
        implements BaseEntityRepository<T, ID> {
    protected EntityManager entityManager;

    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void deleteById(ID id) {
        entityManager.remove(id);
    }

    @Override
    public T findById(ID id) {
        return entityManager.find(getClassType(), id);
    }

    @Override
    public Collection<T> findAll() {
        return entityManager.createQuery("from " + getClassType().getSimpleName(),
                getClassType()).getResultList();
    }

    @Override
    public long getCount() {
        return
                entityManager.createQuery("select count( e ) from "
                                + getClassType().getSimpleName() + " e ", Long.class)
                        .getSingleResult();
    }

    @Override
    public Collection<T> saveAll(Collection<T> entityCollection) {
        List<T> savedEntity=new ArrayList<>();
        entityCollection.forEach(e->savedEntity.add(save(e)));
        return savedEntity;
    }

    @Override
    public void beginTransaction() {
        if (!entityManager.getTransaction().isActive())
            entityManager.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().commit();
    }

    @Override
    public void rollBack() {
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().rollback();
    }

    public abstract Class<T> getClassType();
}
