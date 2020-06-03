package it.cnit.siteinventory.network;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "networks", path = "networks")
public interface NetworkRepository extends PagingAndSortingRepository<Network, Long> {

}
