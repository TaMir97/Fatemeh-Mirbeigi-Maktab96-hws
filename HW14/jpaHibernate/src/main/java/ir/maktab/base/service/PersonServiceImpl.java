package ir.maktab.base.service;

import ir.maktab.base.domain.Person;
import ir.maktab.base.repository.PersonRepo;

import java.util.Collection;

public class PersonServiceImpl implements PersonService {

    private final PersonRepo repository;

    public PersonServiceImpl(PersonRepo repository) {
        this.repository = repository;
    }


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
        repository.deleteById(id);
    }

    @Override
    public Collection<Person> loadAll() {
        return repository.loadAll();
    }

    @Override
    public boolean contains(Person person) {
        return repository.contains(person);
    }

    @Override
    public Collection<Person> saveAll(Collection<Person> people) {
        return repository.saveAll(people);
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
