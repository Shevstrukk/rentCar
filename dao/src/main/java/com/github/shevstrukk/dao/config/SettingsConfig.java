package com.github.shevstrukk.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@PropertySource("classpath:datasourse.properties")
public class SettingsConfig {
    @Bean
    public DatasourseSettings datasourseSettings() {
        return new DatasourseSettings();
    }

    public Properties hibernateProperties() {
        try (final InputStream inputStream = new ClassPathResource("hibernate.properties").getInputStream()) {
            final Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
