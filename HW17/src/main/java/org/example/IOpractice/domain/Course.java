package org.example.IOpractice.domain;

import org.example.IOpractice.base.domain.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Course extends BaseEntity<Long> {
    private String courseName;
    private String date;
    @OneToOne(cascade = CascadeType.ALL)
    private CourseRating courseRating;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;
    public Course() {
    }

    public Course(Long aLong) {
        super(aLong);
    }

    public Course(String courseName, String date) {
        this.courseName = courseName;
        this.date = date;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CourseRating getCourseRating() {
        return courseRating;
    }

    public void setCourseRating(CourseRating courseRating) {
        this.courseRating = courseRating;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", data=" + date +
                "} " + super.toString();
    }
}
