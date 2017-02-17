package by.it.milosh.dao;

import by.it.milosh.pojos.User;

import java.util.List;

/**
 * Created by USER on 17.02.2017.
 */
public interface UserDao {

    void addUser(User user);

    User findUserByName(String username);

    User findUserById(Long user_id);

    List<User> getAllUser();

}
