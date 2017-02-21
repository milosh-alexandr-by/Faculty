package by.it.milosh.serviceImpl;

import by.it.milosh.dao.UserCourseDao;
import by.it.milosh.pojos.UserCourse;
import by.it.milosh.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by USER on 19.02.2017.
 */
@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Autowired
    private UserCourseDao userCourseDao;

    @Override
    public List<UserCourse> getAllUserCourse() {
        return userCourseDao.getAllUserCourse();
    }

    @Override
    public List<UserCourse> getAllUserCourseByUserId(Long user_id) {
        return userCourseDao.getAllUserCourseByUserId(user_id);
    }

    @Override
    public void addCourseToUser(Long user_id, Long course_id) {
        userCourseDao.addCourseToUser(user_id, course_id);
    }
}
