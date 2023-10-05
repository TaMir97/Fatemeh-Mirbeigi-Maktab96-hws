package org.example.IOpractice.service.impl;

import org.example.IOpractice.base.service.impl.BaseServiceImpl;
import org.example.IOpractice.domain.CourseRating;
import org.example.IOpractice.repository.CourseRatingRepository;
import org.example.IOpractice.service.CourseRatingService;

public class CourseRatingServiceImpl
        extends BaseServiceImpl<CourseRating, Long, CourseRatingRepository>
        implements CourseRatingService {
    public CourseRatingServiceImpl(CourseRatingRepository repository) {
        super(repository);
    }
}
