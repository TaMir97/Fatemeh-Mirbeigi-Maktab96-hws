package ir.maktab.base.repository;

import ir.maktab.base.domain.Person;
import ir.maktab.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class PersonRepoImpl<T extends Person> implements PersonRepo<T> {
    EntityManager entityManager = HibernateUtil.getEntityManager();

    @Override
    public T saveOrUpdate(T entity) {
        beginTransaction();
        entity = saveWithoutTransaction(entity);
        commitTransaction();
        entityManager.clear();
        return entity;
    }

    public T saveWithoutTransaction(T entity) {
        if (entity.getPersonId() == null)
            entityManager.persist(entity);
        else
            entity = entityManager.merge(entity);

        return entity;
    }


    @Override
    public void deleteById(Long id) {
        beginTransaction();
        entityManager.remove(id);
        commitTransaction();
    }

    @Override
    public Collection<T> loadAll() {
        return entityManager.createQuery("from "+ getEntityClass().getSimpleName(),getEntityClass()).getResultList();
    }


    @Override
    public Collection<T> saveAll(Collection<T> entityCollection) {
        beginTransaction();
        List<T> savedEntity=new ArrayList<>();
        entityCollection.forEach(e->savedEntity.add(saveWithoutTransaction(e)));
        commitTransaction();
        return savedEntity;
    }

    @Override
    public boolean contains(T entity) {
        return entityManager.find(getEntityClass(), entity) != null;
    }

    @Override
    public void beginTransaction() {
        if (!entityManager.getTransaction().isActive())
            entityManager.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public void rollBack() {
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().rollback();
    }

    public abstract Class<T> getEntityClass();
}
