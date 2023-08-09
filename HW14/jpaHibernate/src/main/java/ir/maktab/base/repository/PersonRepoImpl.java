package ir.maktab.base.repository;

import ir.maktab.base.domain.Person;
import ir.maktab.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonRepoImpl implements PersonRepo {
    EntityManager entityManager = HibernateUtil.getEntityManager();

    @Override
    public Person save(Person person) {
        entityManager.persist(person);
        return person;
    }

    @Override
    public void update(Person person) {
        entityManager.merge(person);
    }

    @Override
    public void deleteById(Long id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }

    @Override
    public Collection<Person> loadAll() {
        return entityManager.createQuery("from " + Person.class.getSimpleName(),
                Person.class).getResultList();
    }


    @Override
    public Collection<Person> saveAll(Collection<Person> people) {
        beginTransaction();
        List<Person> savedPeople = new ArrayList<>();
        people.forEach(e -> savedPeople.add(save(e)));
        commitTransaction();
        return savedPeople;
    }

    @Override
    public boolean contains(Person person) {
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

}