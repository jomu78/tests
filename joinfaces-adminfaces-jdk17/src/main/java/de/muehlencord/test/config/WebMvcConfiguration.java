package de.muehlencord.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * configure web application.
 *
 * @author Joern Muehlencord, 2023-01-25
 * @since 0.1.0
 */

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

  /**
   * add automatic redirect to the login page
   *
   * @param registry the registry to add the redirect controller to
   */
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("redirect:/web/index.xhtml");
    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
  }

}
