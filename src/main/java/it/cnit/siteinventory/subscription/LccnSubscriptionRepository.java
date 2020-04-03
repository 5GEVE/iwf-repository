package it.cnit.siteinventory.subscription;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "subscriptions", path = "subscriptions")
public interface LccnSubscriptionRepository extends PagingAndSortingRepository<LccnSubscription, Long> {
}
