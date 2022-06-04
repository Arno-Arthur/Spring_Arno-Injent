package com.arno.service;

import com.arno.domain.Token;
import com.arno.domain.User;

import java.util.List;

public interface UserService {

    User insert(User user);

    List<User> getAll();

    User getById(int id);

    void deleteById(int id);

    User getByLoginAndPassword(String login, String password);
}
