package it.cnit.iwf_repository.zone;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "ranZones", path = "ranZones")
@Tag(name = "RAN Zones")
public interface RanZoneRepository extends PagingAndSortingRepository<RanZone, Long> {

}
