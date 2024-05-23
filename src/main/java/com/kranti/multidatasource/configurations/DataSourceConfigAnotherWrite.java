package com.kranti.multidatasource.configurations;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static com.kranti.multidatasource.DemoApplication.MODEL_PACKAGE;

import javax.persistence.EntityManagerFactory;


@Configuration
@ConfigurationProperties("spring.datasource-another-write")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryAnotherWrite",
        transactionManagerRef = "transactionManagerAnotherWrite",
        basePackages = {"com.kranti.multidatasource.repository.anotherWriteRepository"}
)
public class DataSourceConfigAnotherWrite extends HikariConfigAnotherWrite {

    public DataSourceConfigAnotherWrite(HikariAnotherWriteProperties hikariAnotherWriteProperties) {
        super(hikariAnotherWriteProperties);
    }

    @Bean
    public HikariDataSource dataSourceAnotherWrite() {
        return new HikariDataSource(this);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryAnotherWrite(
            final HikariDataSource dataSourceAnotherWrite) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSourceAnotherWrite);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_ANOTHER_WRITE_PROPERTIES);
        }};
    }

    @Bean
    public PlatformTransactionManager transactionManagerAnotherWrite(EntityManagerFactory entityManagerFactoryAnotherWrite) {
        return new JpaTransactionManager(entityManagerFactoryAnotherWrite);
    }
}
