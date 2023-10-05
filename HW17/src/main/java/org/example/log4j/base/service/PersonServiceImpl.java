package org.example.log4j.base.service;


import org.example.log4j.base.domain.Person;
import org.example.log4j.base.repository.PersonRepo;
import org.example.log4j.base.repository.PersonRepoImpl;
import org.example.log4j.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.logging.Logger;

public class PersonServiceImpl<T extends Person> implements PersonService<Person> {

    private static final Logger logger = Logger.getLogger(PersonServiceImpl.class.getName());
    private final EntityManager entityManager = HibernateUtil.getEntityManager();

    private final PersonRepo<Person> repository = new PersonRepoImpl<>(entityManager);


    @Override
    public Person singUp(String firstname, String lastname) {
        logger.info("Saved person: " + firstname + " " + lastname);
        Person person = new Person();
        person.setFirstname(firstname);
        person.setLastname(lastname);
        beginTransaction();
        Person saved = repository.save(person);
        commitTransaction();

        return saved;
    }

    @Override
    public void update(Person person) {
        logger.info("Updated person with ID: " + person.getPersonId());
        beginTransaction();
        repository.update(person);
        commitTransaction();
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Deleted person with ID: " + id);
        beginTransaction();
        repository.deleteById(id);
        commitTransaction();
    }

    @Override
    public Collection<Person> loadAll(Class<Person> clazz){
        logger.info("loaded list: " + clazz);
        return repository.loadAll(clazz);
    }

    @Override
    public boolean contains(Person person) {
        logger.info("list contains person with ID: " + person.getPersonId());
        return repository.contains(person);
    }

    @Override
    public void beginTransaction() {
        logger.info("transaction began");
        repository.beginTransaction();
    }

    @Override
    public void commitTransaction() {
        logger.info("transaction committed");
        repository.commitTransaction();
    }

    @Override
    public void rollBack() {
        logger.info("transaction rolled back");
        repository.rollBack();
    }
}
