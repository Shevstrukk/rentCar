package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.UserDAO;
import com.github.shevstrukk.model.Address;
import com.github.shevstrukk.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
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
        User bob = new  User(2l, "cc","ff", "666666", null, null, null);
        users.add(bob);
        when(dao.getUsers()).thenReturn(users);
        List<User> fromDB = service.getUsers();
        assertEquals(users.get(0), fromDB.get(0));

    }

    @Test
    public void save() {
        User bob = new  User(null, "cc","ff", "666666", null, null, null);
        when(dao.save(bob)).thenReturn(bob);
        User fromdb = service.save(bob);
        assertEquals(bob, fromdb);
    }

    @Test
    public void getUserById() {
        User bob = new  User(5l, "cc","ff", "666666", null, null, null);
        when(dao.getUserById(bob.getId())).thenReturn(bob);
        User userDB= service.getUserById(bob.getId());
        assertNotNull(userDB);
        assertEquals(bob.getId(), userDB.getId());

    }
}
