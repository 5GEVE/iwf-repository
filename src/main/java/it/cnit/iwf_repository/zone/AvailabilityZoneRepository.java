package it.cnit.iwf_repository.zone;

import it.cnit.iwf_repository.zone.AvailabilityZone.Location;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "availabilityZones", path = "availabilityZones")
public interface AvailabilityZoneRepository extends
    PagingAndSortingRepository<AvailabilityZone, Long> {

  List<AvailabilityZone> findByLocation(@Param("location") Location location);
}
