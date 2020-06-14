package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.UserDAO;
import com.github.shevstrukk.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultUserServiceTest {
    @InjectMocks
    DefaultUserService service;
    @Mock
    UserDAO dao;
    @Test
    public void getUsers() {
        List<User> users = new ArrayList<>();
        User bob = new User(null, "bob", "bob", "444444");
        users.add(bob);
        when(dao.getUsers()).thenReturn(users);
        List<User> fromDB = service.getUsers();
        assertEquals(users.get(0), fromDB.get(0));

    }

    @Test
    public void save() {
        User user = new User(50000000l, "hh","ll", "5555555");
        when(dao.save(user)).thenReturn(50000000l);
        Long id = service.save(user);
        assertEquals(user.getId(),id);
    }

    @Test
    public void getUserById() {
    }
}
