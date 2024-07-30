package br.edu.utfpr.atividade_jpa.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("br.edu.utfpr.atividade_jpa.repository")
@EnableTransactionManagement
public class SpringDataConfig {

    @Bean
    public DataSource dataSource(){
        HikariDataSource ds = new HikariDataSource();

        ds.setUsername("root");
        ds.setPassword("90Wg!dev");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/empresa");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");

        return ds;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(){

        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();

        HibernateJpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);

        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("br.edu.utfpr.atividade_jpa.entity");
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager manager =
                new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory());
        manager.setJpaDialect(new HibernateJpaDialect());

        return manager;
    }
}
