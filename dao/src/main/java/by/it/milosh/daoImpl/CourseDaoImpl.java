package by.it.milosh.daoImpl;

import by.it.milosh.dao.CourseDao;
import by.it.milosh.pojos.Course;
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
public class CourseDaoImpl implements CourseDao {

    private SessionFactory sessionFactory;

    @Autowired
    public CourseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<Course> getAllCourses() {
        Session session = currentSession();
        Transaction tr = session.beginTransaction();
        String hql = "from Course";
        Query query = session.createQuery(hql);
        List<Course> courses = query.list();
        tr.commit();
        return courses;
    }

    @Override
    public void addCourse(Course course) {
        Session session = currentSession();
        Transaction tr = session.beginTransaction();
        session.saveOrUpdate(course);
        tr.commit();
    }
}
