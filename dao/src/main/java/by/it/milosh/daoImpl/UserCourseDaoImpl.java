package by.it.milosh.daoImpl;

import by.it.milosh.dao.UserCourseDao;
import by.it.milosh.pojos.Course;
import by.it.milosh.pojos.User;
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

    @Override
    public List<UserCourse> getAllUserCourseByUserId(Long user_id) {
        Session session = currentSession();
        Transaction tr = session.beginTransaction();
        String hql = "from UserCourse uc where uc.user.user_id=:user_id";
        Query query = session.createQuery(hql);
        query.setParameter("user_id", user_id);
        List<UserCourse> userCourses = query.list();
        tr.commit();
        return userCourses;
    }

    @Override
    public void addCourseToUser(Long user_id, Long course_id) {
        Session session = currentSession();
        Transaction tr = session.beginTransaction();
        User user = (User) session.get(User.class, user_id);
        Course course = (Course) session.get(Course.class, course_id);
        UserCourse userCourse = new UserCourse();
        userCourse.setUser(user);
        userCourse.setCourse(course);
        session.saveOrUpdate(userCourse);
        tr.commit();
    }
}
