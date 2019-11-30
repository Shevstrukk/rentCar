package com.github.Shevstrukk.dao.config;

import com.github.Shevstrukk.dao.AuthUsersDAO;
import com.github.Shevstrukk.dao.DefaultAuthUsersDAO;
import com.github.Shevstrukk.dao.DefaultPersonDAO;
import com.github.Shevstrukk.dao.PersonDAO;
import com.github.Shevstrukk.dao.address.AddressDao;
import com.github.Shevstrukk.dao.address.DefaultAddressDao;
import com.github.Shevstrukk.dao.carDao.CarsDAO;
import com.github.Shevstrukk.dao.carDao.DefaultCarDAO;
import com.github.Shevstrukk.dao.orderDao.DefaultOrderDAO;
import com.github.Shevstrukk.dao.orderDao.OrderDAO;
import com.github.Shevstrukk.dao.phonedao.DefaultPhoneDAO;
import com.github.Shevstrukk.dao.phonedao.PhoneDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DaoConfig {

    @Bean
    public AddressDao addressDao() {
        return new DefaultAddressDao();
    }
    @Bean
    public CarsDAO carDao() {
        return new DefaultCarDAO();
    }
    @Bean
    public OrderDAO orderDao() {
        return new DefaultOrderDAO();
    }
    @Bean
    public PhoneDAO phoneDao() {
        return new DefaultPhoneDAO();
    }
    @Bean
    public AuthUsersDAO authUsersDao() {
        return new DefaultAuthUsersDAO();
    }
    @Bean
    public PersonDAO personDao() {    return new DefaultPersonDAO();    }
}
