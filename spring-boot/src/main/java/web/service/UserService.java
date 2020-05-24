package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public boolean addUser(User user);

    public boolean updateUser(Long id, String name, String surName, String password);

    public boolean deleteUser(User user);

    public List<User> getAllUser();
}
