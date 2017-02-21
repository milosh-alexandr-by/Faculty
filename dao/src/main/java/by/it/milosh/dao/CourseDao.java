package by.it.milosh.dao;

import by.it.milosh.pojos.Course;

import java.util.List;

/**
 * Created by USER on 19.02.2017.
 */
public interface CourseDao {

    List<Course> getAllCourses();

    void addCourse(Course course);

    Course findCourseByName(String courseName);

}
