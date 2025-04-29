package de.muehlencord.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Demonstrate AOT problems related SpringFramework 6.2.6
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
