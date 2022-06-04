package com.arno.service;

import com.arno.domain.Organization;
import com.arno.domain.Token;
import com.arno.domain.User;
import com.arno.repository.OrganizationR;
import com.arno.repository.UserR;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserR userR;
    private final OrganizationR organizationR;

    @Override
    public User insert(User user) {
        return userR.save(user);
    }

    @Override
    public List<User> getAll() {
        return userR.findAll();
    }

    @Override
    public User getById(int id) {
        return userR.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        userR.deleteById(id);
    }

    @Override
    public User getByLoginAndPassword(String login, String password) {
        User user = userR.getByLoginAndPassword(login,password);
        return user;
    }
}
