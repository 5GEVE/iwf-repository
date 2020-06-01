package it.cnit.siteinventory.site;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "sites", path = "sites")
public interface SiteRepository extends PagingAndSortingRepository<Site, Long> {

  List<Site> findByNameIgnoreCase(@Param("name") String name);
}
