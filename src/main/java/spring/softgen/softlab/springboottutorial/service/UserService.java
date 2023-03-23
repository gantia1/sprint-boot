package spring.softgen.softlab.springboottutorial.service;

import spring.softgen.softlab.springboottutorial.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    List<User> deletedUsers();

    User add(User user);

    User update(int id, User user);

    void delete(int id);

    User getUser(int id);
}
