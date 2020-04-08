package it.cnit.siteinventory.notification;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "notificationTypes", path = "notificationTypes")
public interface NotificationTypeRepository extends PagingAndSortingRepository<NotificationType, Long> {

    // Forbid POST
    @Override
    @RestResource(exported = false)
    <S extends NotificationType> S save(S s);

    // Forbid DELETE
    @Override
    @RestResource(exported = false)
    void delete(NotificationType notificationType);
}
