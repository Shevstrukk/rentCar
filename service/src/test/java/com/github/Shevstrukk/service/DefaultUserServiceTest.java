package com.github.Shevstrukk.service;


import com.github.Shevstrukk.dao.AuthUsersDAO;
import com.github.Shevstrukk.model.AuthUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultUserServiceTest {
    @InjectMocks
    DefaultUserService service;
    @Mock
    AuthUsersDAO authUsersDAO;

    @Test
    public void login() {
        AuthUser authUser = new AuthUser(null, "vitalij", "1", "admin", null);
        when(authUsersDAO.getByLogin("vitalij")).thenReturn(authUser);
        AuthUser authUserDB = service.login("vitalij", "1");
        assertNotNull(authUserDB);
        assertEquals(authUserDB.getLogin(), "vitalij");
    }
}