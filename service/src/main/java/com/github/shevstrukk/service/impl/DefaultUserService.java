package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.UserDAO;
import com.github.shevstrukk.dao.impl.DefaultUserDao;
import com.github.shevstrukk.model.User;
import com.github.shevstrukk.service.UserService;

import java.util.List;

public class DefaultUserService implements UserService {
private UserDAO userDAO = DefaultUserDao.getInstance();
    private static volatile UserService instance;
    public static UserService getInstance(){
        UserService local = instance;
        if(local==null){
            synchronized (UserService.class){
                local=instance;
                if (local==null){
                    local=instance=new DefaultUserService();
                }
            }
        }
        return local;
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public Long save(User user) {
        return userDAO.save( user);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }
}
