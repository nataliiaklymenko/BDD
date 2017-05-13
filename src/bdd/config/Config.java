package bdd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by argentum on 13.05.17.
 */
@Configuration
@Import({DataSourceConfig.class, JpaConfig.class, RepositoryConfig.class})
public class Config {
}
