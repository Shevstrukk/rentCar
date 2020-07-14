package com.github.shevstrukk.dao.config;

import com.github.shevstrukk.dao.*;
import com.github.shevstrukk.dao.impl.*;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(HibernateConfig.class)
@EnableTransactionManagement
@ComponentScan(basePackages = "com.github.shevstrukk.dao")
public class DaoConfig {

    private SessionFactory sessionFactory;

    public DaoConfig(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Bean
    public AuthUserDao authUserDao() {
        return new DefaultAuthUserDao(sessionFactory);
    }
    @Bean
    public UserDAO userDao() {return new DefaultUserDao(sessionFactory);    }
    @Bean
    public AddressDao addressDao() {return new DefaultAddressDao(sessionFactory);    }
    @Bean
    public CarDao carDao( ) {return new DefaultCarDao (sessionFactory);    }
    @Bean
    public OrderDao orderDao() {return new DefaultOrderDao(sessionFactory);    }
    @Bean
    public RentalPeriodDao rentalPeriodDao() {return new DefaultRentalPeriodDao(sessionFactory);}
}
