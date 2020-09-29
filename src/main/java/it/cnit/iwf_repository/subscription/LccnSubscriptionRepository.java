package it.cnit.iwf_repository.subscription;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "subscriptions", path = "subscriptions")
@Tag(name = "Subscriptions")
public interface LccnSubscriptionRepository extends
    PagingAndSortingRepository<LccnSubscription, Long> {

  List<LccnSubscription> findByNsInstanceId(@Param("nsInstanceId") UUID nsInstanceId);
}
