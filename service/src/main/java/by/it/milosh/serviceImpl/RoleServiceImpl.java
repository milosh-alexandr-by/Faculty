package by.it.milosh.serviceImpl;

import by.it.milosh.dao.RoleDao;
import by.it.milosh.pojos.Role;
import by.it.milosh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by USER on 17.02.2017.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findRoleByName(String roleName) {
        return roleDao.findRoleByName(roleName);
    }
}
