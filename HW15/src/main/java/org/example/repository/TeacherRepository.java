package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.domain.Teacher;

public interface TeacherRepository extends BaseRepository<Teacher,Long> {
    Teacher findByUsernameAndPassword(String username, String password);
}
