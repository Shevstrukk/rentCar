package com.github.Shevstrukk.service;

import com.github.Shevstrukk.dao.config.DaoConfig;
import com.github.Shevstrukk.service.address.AddressService;
import com.github.Shevstrukk.service.address.DefaultAddressService;
import com.github.Shevstrukk.service.carService.CarsService;
import com.github.Shevstrukk.service.carService.DefaultCarsService;
import com.github.Shevstrukk.service.orderService.DefaultOrderService;
import com.github.Shevstrukk.service.orderService.OrderService;
import com.github.Shevstrukk.service.phoneservice.DefaultPhoneService;
import com.github.Shevstrukk.service.phoneservice.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.github.Shevstrukk.service")
public class ConfigService {

    private DaoConfig daoConfig;
    @Autowired
    public ConfigService(DaoConfig daoConfig){
        this.daoConfig = daoConfig;
    }

    @Bean
    UserService userService () {return new DefaultUserService(daoConfig.authUsersDao()); }
    @Bean
    PersonService personService() { return new DefaultPersonService(daoConfig.personDao()); }
    @Bean
    AddressService addressService() {return new DefaultAddressService(daoConfig.addressDao());    }
    @Bean
    CarsService carsService(){ return new DefaultCarsService(daoConfig.carDao());    }
    @Bean
    OrderService orderService() {return new DefaultOrderService(daoConfig.orderDao());   }
    @Bean
    PhoneService phoneService( ){return new DefaultPhoneService(daoConfig.phoneDao());
    }
}
