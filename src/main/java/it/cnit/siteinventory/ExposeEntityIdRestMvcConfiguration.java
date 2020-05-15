package it.cnit.siteinventory;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

@Component
public class ExposeEntityIdRestMvcConfiguration implements RepositoryRestConfigurer {

  private final EntityManager entityManager;

  public ExposeEntityIdRestMvcConfiguration(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(Type::getJavaType)
        .toArray(Class[]::new));
  }
}
