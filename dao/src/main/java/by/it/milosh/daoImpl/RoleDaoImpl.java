package by.it.milosh.daoImpl;

import by.it.milosh.dao.RoleDao;
import by.it.milosh.pojos.Role;
import by.it.milosh.pojos.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by USER on 17.02.2017.
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    private SessionFactory sessionFactory;

    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public Role findRoleByName(String roleName) {
        Session session = currentSession();
        Criteria criteria = session.createCriteria(Role.class);
        criteria.add(Restrictions.eq("roleName", roleName));
        return (Role) criteria.uniqueResult();
    }
}
