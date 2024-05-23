package com.kranti.multidatasource.configurations;

import com.zaxxer.hikari.HikariConfig;

import java.util.Properties;

public class HikariConfigAnotherWrite extends HikariConfig {

    protected final HikariAnotherWriteProperties hikariAnotherWriteProperties;

    protected final String PERSISTENCE_UNIT_NAME = "another-write";

    protected final Properties JPA_ANOTHER_WRITE_PROPERTIES = new Properties() {{
        put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        put("hibernate.hbm2ddl.auto", "update");
        put("hibernate.ddl-auto", "update");
        put("show-sql", "true");
    }};

    protected HikariConfigAnotherWrite(HikariAnotherWriteProperties hikariAnotherWriteProperties) {
        this.hikariAnotherWriteProperties = hikariAnotherWriteProperties;
        setPoolName(this.hikariAnotherWriteProperties.getPoolName());
        setMinimumIdle(this.hikariAnotherWriteProperties.getMinimumIdle());
        setMaximumPoolSize(this.hikariAnotherWriteProperties.getMaximumPoolSize());
        setIdleTimeout(this.hikariAnotherWriteProperties.getIdleTimeout());
    }
}
