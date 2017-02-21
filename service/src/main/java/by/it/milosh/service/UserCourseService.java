package by.it.milosh.service;

import by.it.milosh.pojos.Course;
import by.it.milosh.pojos.User;
import by.it.milosh.pojos.UserCourse;

import java.util.List;

/**
 * Created by USER on 19.02.2017.
 */
public interface UserCourseService {

    List<UserCourse> getAllUserCourse();

    List<UserCourse> getAllUserCourseByUserId(Long user_id);

    void addCourseToUser(Long user_id, Long course_id);

}
