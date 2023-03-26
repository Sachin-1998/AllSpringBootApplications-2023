package com.nt.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.nt.product.repository"},entityManagerFactoryRef = "MySqlEMPF",transactionManagerRef = "MySqlTaxManager")
public class MySqlDbConfig
{
    @Bean(name="MysqlDs")
    @ConfigurationProperties(prefix = "mysql.datasource")
    @Primary
    public DataSource createDatasource()
    {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="MySqlEMPF")
    @Primary
    public LocalContainerEntityManagerFactoryBean createMyLocalContainerEntityManagerFactoryBean(EntityManagerFactoryBuilder builder)
    {
        //create map object
        Map<String,Object> props=new HashMap<>();
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.format_sql", "true");

        //create and return LocalContainerEntityManagerFactoryBean object
        //which makes entity manager factory as spring bean

       return  builder.dataSource(createDatasource()).packages("com.nt.entity.prod").properties(props).build();

    }

    @Bean(name="MySqlTaxManager")
    @Primary
    public JpaTransactionManager createTxManager(
           @Qualifier("MySqlEMPF") EntityManagerFactory factory)
    {
        return new JpaTransactionManager(factory);
    }


}
