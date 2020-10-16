package it.cnit.iwf_repository.area;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "coverageAreas", path = "coverageAreas")
@Tag(name = "Radio Coverage Areas")
public interface CoverageAreaRepository extends PagingAndSortingRepository<CoverageArea, Long> {

  @Query(nativeQuery = true, value = "select ca.* from site join ran_orchestrator ro join coverage_area ca "
      + "on ro.id = ca.ran_orchestrator_id on site.id = ro.site_id where site.name=:name")
  Optional<List<CoverageArea>> findBySiteName(String name);

  @Query(nativeQuery = true, value = "select ca.* from site join ran_orchestrator ro join coverage_area ca "
      + "on ro.id = ca.ran_orchestrator_id on site.id = ro.site_id where site.id=:id")
  Optional<List<CoverageArea>> findBySiteId(long id);

  // TODO add find by tech

}
