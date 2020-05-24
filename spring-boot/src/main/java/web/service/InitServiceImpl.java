package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;

import java.util.HashSet;
import java.util.Set;

@Service
public class InitServiceImpl implements InitService {

    private UserDao userDao;

    @Autowired
    public InitServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void addAdminAndUser() {
        if (!userDao.isNotReg("admin")) {
            Set<Role> admin = new HashSet<>();
            admin.add(new Role("admin"));
            admin.add(new Role("user"));
            userDao.addUser(new User("admin", "admin", admin));

            Set<Role> user = new HashSet<>();
            user.add(new Role("user"));
            userDao.addUser(new User("user", "user", user));
        }
    }
}
