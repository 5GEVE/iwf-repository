package it.cnit.iwf_repository.network;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "networks", path = "networks")
public interface NetworkRepository extends PagingAndSortingRepository<Network, Long> {

}
