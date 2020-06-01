package it.cnit.siteinventory.network;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "networks", path = "networks")
public interface NetworkRepository extends
    PagingAndSortingRepository<Network, Long> {

  List<Network> findByVimNetworkName(@Param("vimNetworkName") String vimNetworkName);

  List<Network> findByManagement(@Param("management") boolean management);
}
