package by.it.milosh.dao;

import by.it.milosh.pojos.Role;
import by.it.milosh.pojos.User;

/**
 * Created by USER on 17.02.2017.
 */
public interface RoleDao {

    Role findRoleByName(String roleName);

}
