package it.cnit.iwf_repository.zone;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "coverageAreas", path = "coverageAreas")
@Tag(name = "Radio Coverage Areas")
public interface CoverageAreaRepository extends PagingAndSortingRepository<CoverageArea, Long> {

}
