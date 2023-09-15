package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.domain.Student;
import org.example.domain.enums.*;

import java.time.LocalDate;

public interface StudentRepository extends BaseRepository<Student, Long> {
    Student findByBirthCertificateId(Long birthCertificateId);
}
