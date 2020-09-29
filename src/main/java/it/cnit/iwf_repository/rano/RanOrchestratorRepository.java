package it.cnit.iwf_repository.rano;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "ranOrchestrators", path = "ranOrchestrators")
@Tag(name = "RAN Orchestrators")
public interface RanOrchestratorRepository extends
    PagingAndSortingRepository<RanOrchestrator, Long> {

}
