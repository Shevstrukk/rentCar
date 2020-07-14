package com.github.shevstrukk.service.config;

import com.github.shevstrukk.dao.config.DaoConfig;
import com.github.shevstrukk.service.*;
import com.github.shevstrukk.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    private  DaoConfig daoConfig;

    public ServiceConfig(DaoConfig daoConfig) {
        this.daoConfig = daoConfig;
    }
    @Bean
    public AddressService addressService() {return new DefaultAddressService(daoConfig.addressDao());}
    @Bean
    public CarsService carsService() {return new DefaultCarsService(daoConfig.carDao());}
    @Bean
    public OrderService orderService() {return new DefaultOrderService(daoConfig.orderDao());}
    @Bean
    public RentalPeriodService rentalPeriodService() {return        new DefaultRentalPeriodService(daoConfig.rentalPeriodDao());    }
    @Bean
    public SecurityService securityService() {return new DefaultSecurityService(daoConfig.authUserDao());      }
    @Bean
    public UserService userService() {return new DefaultUserService(daoConfig.userDao());}
}
