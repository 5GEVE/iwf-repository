package it.cnit.siteinventory.site;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "sites", path = "sites")
public interface SiteRepository extends PagingAndSortingRepository<Site, Long> {
}
