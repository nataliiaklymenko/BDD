package bdd.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by argentum on 13.05.17.
 */
@ContextConfiguration
@EnableJpaRepositories(basePackages = "jpa")
public class RepositoryConfig {
}
