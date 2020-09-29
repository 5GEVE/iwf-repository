package it.cnit.iwf_repository.site;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "sites", path = "sites")
@Tag(name = "Sites")
public interface SiteRepository extends PagingAndSortingRepository<Site, Long> {

  List<Site> findByNameIgnoreCase(@Param("name") String name);
}
