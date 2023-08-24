package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.domain.ReleasedCourse;

import java.util.List;

public interface ReleasedCourseRepository extends BaseRepository<ReleasedCourse,Long> {
    List<ReleasedCourse> findEligibleReleasedCoursesForStudent(Long studentId);
}
