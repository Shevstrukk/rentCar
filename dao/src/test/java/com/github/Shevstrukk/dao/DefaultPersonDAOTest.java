package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.dao.config.DaoConfig;
import com.github.Shevstrukk.model.AuthUser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
public class DefaultPersonDAOTest {

    @Test
    public void insertPerson() {
        AuthUser authUser= new AuthUser(null, "rom", "rom", "user", null);
    }
}