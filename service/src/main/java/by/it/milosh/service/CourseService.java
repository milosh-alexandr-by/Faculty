package by.it.milosh.service;

import by.it.milosh.pojos.Course;

import java.util.List;

/**
 * Created by USER on 19.02.2017.
 */
public interface CourseService {

    List<Course> getAllCourse();

    void addCourse(Course course);

}
