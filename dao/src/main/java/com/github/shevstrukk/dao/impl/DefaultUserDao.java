package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.UserDAO;
import com.github.shevstrukk.model.User;

import java.util.ArrayList;
import java.util.List;

public class DefaultUserDao implements UserDAO {
private static volatile UserDAO instance;
private List<User> users;
  public DefaultUserDao(){     this.users = new ArrayList<>();}
  public static UserDAO getInstance(){
    UserDAO local = instance;
       if(local==null){
         synchronized (UserDAO.class){
             local=instance;
             if(local==null){
                 instance=local=new DefaultUserDao();
             }
         }

       }
    return local;
  }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public String save(User user) {
        users.add(user);
        return user.getId();
    }
}
