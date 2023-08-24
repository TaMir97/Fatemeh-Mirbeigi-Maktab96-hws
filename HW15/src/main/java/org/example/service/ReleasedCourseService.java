package org.example.service;

import org.example.base.service.BaseService;
import org.example.domain.ReleasedCourse;

import java.util.List;

public interface ReleasedCourseService extends BaseService<ReleasedCourse,Long> {
    List<ReleasedCourse> findEligibleReleasedCoursesForStudent(Long studentId);
}
