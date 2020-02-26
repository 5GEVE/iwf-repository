package it.cnit.nfvoservice;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "nfvos", path = "nfvos")
public interface NfvoRepository extends PagingAndSortingRepository<Nfvo, Long> {
    List<Nfvo> findBySite(@Param("site") String site);
}
