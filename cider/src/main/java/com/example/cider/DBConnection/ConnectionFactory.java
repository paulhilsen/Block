package com.example.cider.DBConnection;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

/**
 * Created by paul.hilsen on 5/30/2017.
 */
@Component
public class ConnectionFactory {

    public BasicDataSource databaseConnection() {

        BasicDataSource connectionPool = new BasicDataSource();
        connectionPool.setDriverClassName("com.mysql.jdbc.Driver");

        connectionPool.setUrl("jdbc:mysql://cidrblock.civmit6ngyak.us-west-2.rds.amazonaws.com");
        connectionPool.setUsername("cider");
        connectionPool.setPassword("yumyumcider");


        connectionPool.setInitialSize(1);

        return connectionPool;

    }

}
