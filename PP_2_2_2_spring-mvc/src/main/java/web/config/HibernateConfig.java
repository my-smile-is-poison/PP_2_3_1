package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(value = "web.model")
public class HibernateConfig {
private final Environment en;

@Autowired
    public HibernateConfig(Environment en) {
        this.en = en;
    }
@Bean
    public JpaTransactionManager transactionManager(){
    JpaTransactionManager jp = new JpaTransactionManager();
    jp.setEntityManagerFactory(localContainerEntityManagerFactoryBean().getObject());
    return jp;
}
    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setDataSource(dataSource());
        em.setPackagesToScan(en.getRequiredProperty("jdbc.entity.package"));
        em.setJpaProperties(getHibernateProperties());
        return em;
    }
    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", en.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", en.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", en.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", en.getRequiredProperty("hibernate.hbm2ddl.auto"));

        return properties;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(en.getRequiredProperty("jdbc.url"));
        ds.setDriverClassName(en.getRequiredProperty("jdbc.driver"));
        ds.setUsername(en.getRequiredProperty("jdbc.username"));
        ds.setPassword(en.getRequiredProperty("jdbc.password"));
        return ds;
    }
}
