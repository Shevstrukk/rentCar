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
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@Import(HibernateConfig.class)
@EnableTransactionManagement
public class DaoConfig {

    private SessionFactory sessionFactory;

   public DaoConfig(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    @Bean
    public AddressDao addressDao() {
        return new DefaultAddressDao( sessionFactory);
    }
    @Bean
    public CarsDAO carDao() {
        return new DefaultCarDAO(sessionFactory);
    }
    @Bean
    public OrderDAO orderDao() {
        return new DefaultOrderDAO(sessionFactory);
    }
    @Bean
    public PhoneDAO phoneDao() {
        return new DefaultPhoneDAO(sessionFactory);
    }
    @Bean
    public AuthUsersDAO authUsersDao() {
        return new DefaultAuthUsersDAO(sessionFactory);
    }
    @Bean
    public PersonDAO personDao() {    return new DefaultPersonDAO(sessionFactory);    }
}
