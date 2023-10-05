package org.example.IOpractice.repository.impl;

import org.example.IOpractice.base.repository.impl.BaseRepositoryImpl;
import org.example.IOpractice.domain.CourseRating;
import org.example.IOpractice.domain.Student;
import org.example.IOpractice.repository.CourseRatingRepository;
import org.example.IOpractice.repository.StudentRepository;

import javax.persistence.EntityManager;

public class CourseRatingRepositoryImpl
        extends BaseRepositoryImpl<CourseRating,Long>
        implements CourseRatingRepository {
    public CourseRatingRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<CourseRating> getEntityClass() {
        return CourseRating.class;
    }
}
