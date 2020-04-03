package it.cnit.siteinventory.nfvo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "nfvos", path = "nfvos")
public interface NfvOrchestratorRepository extends PagingAndSortingRepository<NfvOrchestrator, Long> {
    List<NfvOrchestrator> findByTypeIgnoreCase(@Param("type") String type);
}
