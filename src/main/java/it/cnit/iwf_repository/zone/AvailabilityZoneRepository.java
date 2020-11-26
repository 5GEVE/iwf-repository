package it.cnit.iwf_repository.zone;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.cnit.iwf_repository.zone.AvailabilityZone.Placement;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "availabilityZones", path = "availabilityZones")
@Tag(name = "Availability Zones")
public interface AvailabilityZoneRepository extends
    PagingAndSortingRepository<AvailabilityZone, Long> {

  List<AvailabilityZone> findByPlacement(@Param("placement") Placement placement);
}
