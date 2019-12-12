package com.github.Shevstrukk.web.spring;

import com.github.Shevstrukk.service.ConfigService;
import com.github.Shevstrukk.web.servlets.LoginController;
import com.github.Shevstrukk.web.servlets.LogoutController;
import com.github.Shevstrukk.web.servlets.PersonController;
import com.github.Shevstrukk.web.servlets.RegistrationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
//@ComponentScan(basePackages = "com.github.Shevstrukk.web")
public class WebConfig  {

    private   ConfigService service;
    @Autowired
    public WebConfig(ConfigService service) { this.service = service;    }
    @Bean
    LogoutController logoutController(){return new LogoutController(service.userService());}
    @Bean
    LoginController loginController() {return  new LoginController(service.userService());}
    @Bean
    PersonController personController() {return  new PersonController(service.userService(), service.personService());}
    @Bean
    RegistrationController registrationController() {return  new RegistrationController(service.userService());}


    @Bean
    ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


}
