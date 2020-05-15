package it.cnit.siteinventory.rano;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "ranOrchestrators", path = "ranOrchestrators")
public interface RanOrchestratorRepository extends
    PagingAndSortingRepository<RanOrchestrator, Long> {

}
