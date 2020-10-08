package it.cnit.iwf_repository.nfvo;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "nfvOrchestrators", path = "nfvOrchestrators")
@Tag(name = "NFV Orchestrators")
public interface NfvOrchestratorRepository extends
    PagingAndSortingRepository<NfvOrchestrator, Long> {

  List<NfvOrchestrator> findByTypeIgnoreCase(@Param("type") String type);
}
