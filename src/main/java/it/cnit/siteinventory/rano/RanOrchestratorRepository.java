package it.cnit.siteinventory.rano;

import it.cnit.siteinventory.site.Site;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "ranos", path = "ranos")
public interface RanOrchestratorRepository extends PagingAndSortingRepository<RanOrchestrator, Long> {
}
