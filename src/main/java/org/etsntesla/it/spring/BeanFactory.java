package org.etsntesla.it.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = "org.etsntesla.it.spring")
@PropertySource("classpath:application.properties")
public class BeanFactory {
    @Autowired
    private Environment environment;

    @Bean
    public DatabaseConfiguration factoryDBConfiguration() {
        DatabaseConfiguration config=new DatabaseConfiguration();
        config.setUrl(environment.getProperty("database.url"));
        config.setUser(environment.getProperty("database.user"));
        config.setPass(environment.getProperty("database.pass"));
        return config;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
