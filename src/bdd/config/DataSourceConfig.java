package bdd.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;

/**
 * Created by argentum on 13.05.17.
 */
@Configuration
@ComponentScan
@EnableJpaRepositories
@PropertySource(name = "main", value = "${ENV}.properties")
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class DataSourceConfig {
    @Autowired
    private Environment env;

    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        basicDataSource.setUrl(env.getProperty("database.url"));
        basicDataSource.setUsername(env.getProperty("database.username"));
        basicDataSource.setPassword(env.getProperty("database.password"));
        basicDataSource.setMaxIdle(env.getProperty("database.maxIdle", Integer.class));
        basicDataSource.setMaxWaitMillis(env.getProperty("database.maxWait", Integer.class));
        basicDataSource.setMaxTotal(env.getProperty("database.maxTotal", Integer.class));
        return  basicDataSource;
    }
}
