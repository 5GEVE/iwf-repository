package it.cnit.iwf_repository;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class CorsConfiguration extends RepositoryRestConfigurerAdapter {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

    config.getCorsRegistry().addMapping("/**");
  }
}

