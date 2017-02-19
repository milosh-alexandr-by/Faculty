package by.it.milosh.daoImpl;

import by.it.milosh.dao.UserCourseDao;
import by.it.milosh.pojos.UserCourse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by USER on 19.02.2017.
 */
@Repository
public class UserCourseDaoImpl implements UserCourseDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UserCourseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<UserCourse> getAllUserCourse() {
        Session session = currentSession();
        Transaction tr = session.beginTransaction();
        String hql = "from UserCourse";
        Query query = session.createQuery(hql);
        List<UserCourse> userCourses = query.list();
        tr.commit();
        return userCourses;
    }
}
