package com.github.shevstrukk.web.spring;

import com.github.shevstrukk.service.config.ServiceConfig;
import com.github.shevstrukk.web.controller.LoginController;
import com.github.shevstrukk.web.controller.LogoutController;
import com.github.shevstrukk.web.controller.RegistrationController;
import com.github.shevstrukk.web.controller.UserController;
import com.github.shevstrukk.web.controller.car.CarController;
import com.github.shevstrukk.web.controller.orders.OrderController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@EnableWebMvc
public class WebConfig {
    private ServiceConfig serviceConfig;

    public WebConfig(ServiceConfig serviceConfig) {
        this.serviceConfig = serviceConfig;
    }
    @Bean
    public LoginController loginController() {return new LoginController(serviceConfig.securityService());}
    @Bean
    public LogoutController logoutController(){return new LogoutController(serviceConfig.securityService());}
    @Bean
    public RegistrationController registrationController() {return new RegistrationController(serviceConfig.securityService(),
            serviceConfig.userService(), serviceConfig.addressService());}
    @Bean
    public UserController userController() {return new UserController(serviceConfig.userService(),
                    serviceConfig.securityService(), serviceConfig.addressService());}
     @Bean
     public OrderController orderController() {return new OrderController(serviceConfig.carsService(),
             serviceConfig.rentalPeriodService(), serviceConfig.userService(), serviceConfig.orderService());}
    @Bean
    public CarController carController() {return new CarController(serviceConfig.carsService());}
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
