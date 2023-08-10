package ir.maktab.base.service;

import ir.maktab.base.domain.Person;
import ir.maktab.base.repository.PersonRepo;
import ir.maktab.base.repository.PersonRepoImpl;
import ir.maktab.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Collection;

public class PersonServiceImpl<T extends Person> implements PersonService<Person> {

    private final EntityManager entityManager = HibernateUtil.getEntityManager();

    private final PersonRepo<Person> repository = new PersonRepoImpl<>(entityManager);


    @Override
    public Person singUp(String firstname, String lastname) {
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
        beginTransaction();
        repository.update(person);
        commitTransaction();
    }

    @Override
    public void deleteById(Long id) {
        beginTransaction();
        repository.deleteById(id);
        commitTransaction();
    }

    @Override
    public Collection<Person> loadAll(Class<Person> clazz){
        return repository.loadAll(clazz);
    }

    @Override
    public boolean contains(Person person) {
        return repository.contains(person);
    }

    @Override
    public void beginTransaction() {
        repository.beginTransaction();
    }

    @Override
    public void commitTransaction() {
        repository.commitTransaction();
    }

    @Override
    public void rollBack() {
        repository.rollBack();
    }
}
