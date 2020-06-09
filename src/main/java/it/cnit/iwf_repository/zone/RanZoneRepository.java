package it.cnit.iwf_repository.zone;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "ranZones", path = "ranZones")
public interface RanZoneRepository extends PagingAndSortingRepository<RanZone, Long> {

}
