package by.it.milosh.serviceImpl;

import by.it.milosh.dao.CourseDao;
import by.it.milosh.pojos.Course;
import by.it.milosh.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by USER on 19.02.2017.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourses();
    }

    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    @Override
    public Course findCourseByName(String courseName) {
        return courseDao.findCourseByName(courseName);
    }
}
