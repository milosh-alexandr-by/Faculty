package by.it.milosh.daoImpl;

import by.it.milosh.dao.UserDao;
import by.it.milosh.pojos.Role;
import by.it.milosh.pojos.User;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by USER on 17.02.2017.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void addUser(User user) {
        Session session = currentSession();
        Transaction tr = session.beginTransaction();

//        Set<Role> roles = new HashSet<Role>();
//        Criteria criteria = session.createCriteria(Role.class);
//        criteria.add(Restrictions.eq("roleName", "ROLE_USER"));
//        Role role = (Role) criteria.uniqueResult();
//        roles.add(role);
//
//        user.setRoles(roles);

        session.save(user);
        tr.commit();
    }

    @Override
    public User findUserByName(String username) {
        Session session = currentSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }

    @Override
    public User findUserById(Long user_id) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        Session session = currentSession();
        Transaction tr = session.beginTransaction();
        String hql = "from User";
        Query query = session.createQuery(hql);
        List<User> users = query.list();
        tr.commit();
        return users;
    }
}
