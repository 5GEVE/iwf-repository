package it.cnit.siteinventory.vim;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "vims", path = "vims")
public interface VimRepository extends PagingAndSortingRepository<Vim, Long> {
//    List<Vim> findByNfvo(@Param("nfvo") NfvOrchestrator nfvo);
}
