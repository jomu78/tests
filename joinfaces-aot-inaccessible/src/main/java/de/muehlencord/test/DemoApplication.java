package de.muehlencord.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Demonstrate AOT problems related SpringFramework 6.2.6
 * Caused by: https://github.com/spring-projects/spring-framework/issues/34677 (6.2.6)
 * Fixed by: https://github.com/spring-projects/spring-framework/commit/7f2c1f447f62207aa6eb1f42d4f8f07434bd8913 (6.2.7)
 * See also: https://github.com/spring-projects/spring-framework/issues/34824
 *
 * @author Joern Muehlencord, 2025-04-29
 * @since 1.0.0
 */
@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

}
