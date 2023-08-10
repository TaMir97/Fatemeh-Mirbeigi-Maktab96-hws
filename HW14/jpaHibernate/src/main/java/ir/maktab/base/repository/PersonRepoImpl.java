package ir.maktab.base.repository;

import ir.maktab.base.domain.Person;
import ir.maktab.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.Collection;

public class PersonRepoImpl<T extends Person> implements PersonRepo<T> {
    private final EntityManager entityManager;

    public PersonRepoImpl(EntityManager em) {
        entityManager = em;
    }

    @Override
    public T save(T person) {
        entityManager.persist(person);
        return person;
    }

    @Override
    public void update(T person) {
        entityManager.merge(person);
    }

    @Override
    public void deleteById(Long id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }

    @Override
    public Collection<T> loadAll(Class<T> clazz) {
        return entityManager.createQuery("from " + clazz.getSimpleName(), clazz)
                .getResultList();

    }


    @Override
    public boolean contains(T person) {
        return entityManager.find(Person.class, person) != null;
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

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}