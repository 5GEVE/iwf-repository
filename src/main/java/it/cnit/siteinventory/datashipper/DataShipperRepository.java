package it.cnit.siteinventory.datashipper;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "dataShippers", path = "dataShippers")
public interface DataShipperRepository extends
    PagingAndSortingRepository<DataShipper, Long> {

  List<DataShipper> findByMetricTypeIgnoreCase(@Param("metricType") String metricType);
}
