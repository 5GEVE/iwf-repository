package it.cnit.iwf_repository.network;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "networks", path = "networks")
@Tag(name = "Networks")
public interface NetworkRepository extends PagingAndSortingRepository<Network, Long> {

}
