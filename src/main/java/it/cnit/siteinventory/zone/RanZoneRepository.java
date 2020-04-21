package it.cnit.siteinventory.zone;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "ranZones", path = "RanZones")
public interface RanZoneRepository extends PagingAndSortingRepository<RanZone, Long> {
}
