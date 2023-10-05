package org.example.log4j.repository;

import org.example.log4j.base.repository.PersonRepo;
import org.example.log4j.domain.Stud3nt;

public interface StudentRepo extends PersonRepo<Stud3nt> {
    @Override
    Stud3nt save(Stud3nt person);
}
