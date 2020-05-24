package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public boolean addUser(User user) {
        if (user.getName() != null && user.getSurName() != null) {
            userDao.addUser(user);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean updateUser(Long id, String name, String surName, String password) {
        if (id != null && name != null && surName != null && password != null) {
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setSurName(surName);
            user.setPassword(password);
            userDao.updateUser(user);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean deleteUser(User user) {
        if (user.getId() != null) {
            userDao.deleteUser(user.getId());
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> userMayBy = Optional.ofNullable(userDao.getUserByName(username));
        return userMayBy.orElseThrow(IllegalAccessError::new);
    }
}
