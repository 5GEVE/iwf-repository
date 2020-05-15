package it.cnit.siteinventory.nfvo;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "nfvOrchestrators", path = "nfvOrchestrators")
public interface NfvOrchestratorRepository extends
    PagingAndSortingRepository<NfvOrchestrator, Long> {

  List<NfvOrchestrator> findByTypeIgnoreCase(@Param("type") String type);
}
