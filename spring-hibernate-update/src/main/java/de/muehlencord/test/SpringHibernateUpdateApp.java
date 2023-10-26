package de.muehlencord.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Test Main class
 *
 * @author Joern Muehlencord, 2023-10-26
 * @since 1.0.0
 */
@SpringBootApplication(scanBasePackages = { "de.muehlencord.test" })
@EntityScan(basePackages = { "de.muehlencord.test.entity" })
public class SpringHibernateUpdateApp {

  public static void main(String[] args) {
    SpringApplication.run(SpringHibernateUpdateApp.class, args);
  }
}
