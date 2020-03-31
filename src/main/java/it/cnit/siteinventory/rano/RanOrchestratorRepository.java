package it.cnit.siteinventory.rano;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "ranos", path = "ranos")
public interface RanOrchestratorRepository extends PagingAndSortingRepository<RanOrchestrator, Long> {
}
