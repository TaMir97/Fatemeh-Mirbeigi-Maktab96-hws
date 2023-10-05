package org.example.IOpractice;


import org.example.IOpractice.domain.Course;
import org.example.IOpractice.domain.CourseRating;
import org.example.IOpractice.domain.Student;
import org.example.IOpractice.service.CourseRatingService;
import org.example.IOpractice.service.CourseService;
import org.example.IOpractice.service.StudentService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "file.txt";
        CourseService courseService = ApplicationContext.getCourseService();
        CourseRatingService courseRatingService = ApplicationContext.getCourseRatingService();
        StudentService studentService = ApplicationContext.getStudentService();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 5) {
                    String courseName = fields[0].trim();
                    String studentName = fields[1].trim();
                    String timestamp =fields[2].trim();
                    double rating = Double.parseDouble(fields[3].trim());
                    String comment = fields[4].trim();

                    Student student = new Student();
                    student.setName(studentName);

                    Course course =new Course();
                    course.setCourseName(courseName);
                    course.setDate(timestamp);

                    CourseRating courseRating = new CourseRating();
                    courseRating.setRating(rating);
                    courseRating.setComment(comment);
                    courseRating.setCourse(course);

                    course.setCourseRating(courseRating);

                    courseService.save(course);
                    studentService.save(student);
                    courseRatingService.save(courseRating);


                    System.out.println(course);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String s = Files.readString(Paths.get("file.txt"));
            String[] split = s.split("[,\n]");
            System.out.println(split.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
