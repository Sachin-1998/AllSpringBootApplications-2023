package com.nt.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDataSourceConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.nt.offers.repository"},
                                    transactionManagerRef = "postgresqlTaxManager",
                                    entityManagerFactoryRef = "PostgresqlEMF")
public class PostgreSqlConfig
{
    @Bean(name="postgresqlDs")
    @ConfigurationProperties(prefix = "postgresql.datasource")
    public DataSource createPostgresqlDS()
    {
        return DataSourceBuilder.create().build();
    }
    @Bean(name="PostgresqlEMF")
    public LocalContainerEntityManagerFactoryBean createMyLoaLocalContainerEntityManagerFactoryBean(EntityManagerFactoryBuilder builder)
    {
        //create map object
        //create map object for hibernate properties
        Map<String, Object> map=new HashMap();
        //props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        map.put("hibernate.show_sql", "true");
        map.put("hibernate.hbm2ddl.auto", "update");
        map.put("hibernate.format_sql", "true");

        //create a return LocalContainerEntityManagerFactoryBean class object
        //which makes entity manager factory as spring bean


        return  builder
                .dataSource(createPostgresqlDS())
                .packages("com.nt.entity.promotions")
                .properties(map).build();

    }
    @Bean(name="postgresqlTaxManager")
    public JpaTransactionManager createTaxManager(@Qualifier("PostgresqlEMF") EntityManagerFactory factory)
    {
        return new JpaTransactionManager(factory);
    }
}
