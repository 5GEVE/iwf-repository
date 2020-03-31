package it.cnit.siteinventory.subscription;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "subscriptions", path = "subscriptions")
public interface LccnSubscriptionRepository extends PagingAndSortingRepository<LccnSubscription, Long> {
    List<LccnSubscription> findByNfvo(@Param("nfvo") int nfvo);
}
