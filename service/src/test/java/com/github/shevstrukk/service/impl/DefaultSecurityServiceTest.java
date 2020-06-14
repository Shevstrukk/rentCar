package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.AuthUserDao;
import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.model.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultSecurityServiceTest {
    @Mock
    AuthUserDao dao;

    @InjectMocks
    DefaultSecurityService service;


    @Test
    public void getByLogin() {
        when(dao.getByLogin("admin")).thenReturn(new AuthUser(10000000l, "admin", "admin", Role.ADMIN, 10000000l));
        AuthUser userFromDb = service.getByLogin("admin", "admin");
        assertNotNull(userFromDb);
        assertEquals(userFromDb.getLogin(), "admin");
        assertEquals(userFromDb.getPassword(), "admin");

    }

    @Test
    public void isExist() {
        when(dao.getByLogin("ddd")).thenReturn(null);
        AuthUser fromDB = service.isExist("ddd");
        assertNull(fromDB);
    }

}
