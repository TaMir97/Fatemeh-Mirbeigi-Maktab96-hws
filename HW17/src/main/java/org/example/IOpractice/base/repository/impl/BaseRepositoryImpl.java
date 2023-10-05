package org.example.IOpractice.base.repository.impl;


import org.example.IOpractice.base.domain.BaseEntity;
import org.example.IOpractice.base.repository.BaseRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl
        <T extends BaseEntity<ID>,
                ID extends Serializable>
        implements BaseRepository<T,ID> {

    protected EntityManager entityManger;

    public BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManger = entityManager;
    }

    public abstract Class<T> getEntityClass();


    @Override
    public T save(T entity) {
        entityManger.persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        entityManger.merge(entity);
        return entity;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(( entityManger.find(getEntityClass(),id)));
    }

    @Override
    public void deleteById(ID id) {
        entityManger.remove(id);
    }

    @Override
    public Collection<T> showAll() {
        return entityManger.createQuery("FROM " + getEntityClass().getSimpleName(), getEntityClass()).getResultList();
    }

    @Override
    public long getCount() {
        return entityManger.createQuery("SELECT COUNT( 'count' ) FROM " + getEntityClass().getSimpleName() + "count", Long.class).getSingleResult();
    }

    @Override
    public Collection<T> saveAll(Collection<T> entityCollection) {
        List<T> saveList = new ArrayList<>() ;
        entityCollection.forEach( entity -> saveList.add( save(entity)));
        return saveList;
    }

    @Override
    public void beginTransaction() {
        if (!entityManger.getTransaction().isActive())
            entityManger.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        if (entityManger.getTransaction().isActive())
            entityManger.getTransaction().commit();
    }

    @Override
    public void rollBack() {
        if (entityManger.getTransaction().isActive())
            entityManger.getTransaction().rollback();
    }

    @Override
    public boolean contain(T entity){
        return entityManger.contains(entity);
    }

    @Override
    public boolean contain(ID id){
        return entityManger.contains(id);
    }

}
