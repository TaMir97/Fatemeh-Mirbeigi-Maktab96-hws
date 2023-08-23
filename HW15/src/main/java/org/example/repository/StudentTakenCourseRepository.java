package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.domain.ReleasedCourse;
import org.example.domain.Student;
import org.example.domain.StudentTakenCourse;

public interface StudentTakenCourseRepository extends BaseRepository<StudentTakenCourse,Long> {
    void addCourseByGpa(Student student, ReleasedCourse releasedCourse);
}
