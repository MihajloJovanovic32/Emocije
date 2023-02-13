package org.etsntesla.it.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class MySQLManagerBean {

    @Autowired
    @Qualifier("factoryDBConfiguration")
    private DatabaseConfiguration configuration;

    public Connection getConnection(){
        try {
            return DriverManager.getConnection(configuration.getUrl(),configuration.getUser(),configuration.getPass());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
