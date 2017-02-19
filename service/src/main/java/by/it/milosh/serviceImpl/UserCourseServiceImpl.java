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
}
