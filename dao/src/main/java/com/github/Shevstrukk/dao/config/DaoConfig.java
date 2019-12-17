package com.github.Shevstrukk.dao.config;

import com.github.Shevstrukk.dao.*;
import com.github.Shevstrukk.dao.address.AddressDao;
import com.github.Shevstrukk.dao.address.DefaultAddressDao;
import com.github.Shevstrukk.dao.carDao.CarsDAO;
import com.github.Shevstrukk.dao.carDao.DefaultCarDAO;
import com.github.Shevstrukk.dao.orderDao.DefaultOrderDAO;
import com.github.Shevstrukk.dao.orderDao.OrderDAO;
import com.github.Shevstrukk.dao.phonedao.DefaultPhoneDAO;
import com.github.Shevstrukk.dao.phonedao.PhoneDAO;
import com.github.Shevstrukk.dao.repository.PersonEntityRepository;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@Import(HibernateConfig.class)
@EnableTransactionManagement
@EnableJpaRepositories("com.github.Shevstrukk.dao.repository")
public class DaoConfig {
    private PersonEntityRepository repository;

    private SessionFactory sessionFactory;

    public DaoConfig(PersonEntityRepository repository, SessionFactory sessionFactory) {
        this.repository = repository;
        this.sessionFactory = sessionFactory;
    }

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
    public PersonDAO personDao() {    return new DefaultPersonDAO(sessionFactory, repository);    }
}
