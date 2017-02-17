package by.it.milosh.serviceImpl;

import by.it.milosh.dao.UserDao;
import by.it.milosh.pojos.User;
import by.it.milosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by USER on 17.02.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }

    @Override
    public User findUserById(Long user_id) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }
}
