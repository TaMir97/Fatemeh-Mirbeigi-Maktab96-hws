package org.example.IOpractice.domain;

import org.example.IOpractice.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CourseRating extends BaseEntity<Long> {
    private Double rating;
    private String comment;

    @OneToOne(mappedBy = "courseRating")
    private Course course;

    public CourseRating() {
    }

    public CourseRating(Long aLong) {
        super(aLong);
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseRating{" +
                "rating=" + rating +
                ", comment='" + comment + '\'' +
                "} " + super.toString();
    }
}
