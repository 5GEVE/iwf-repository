package it.cnit.siteinventory.notification;

import it.cnit.siteinventory.constraints.ValueOfEnum;
import it.cnit.siteinventory.subscription.LccnSubscription;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class NotificationType {
    @SuppressWarnings("unused")
    public enum NotificationTypeValue {
        NsLcmOperationOccurenceNotification,
        NsIdentifierCreationNotification,
        NsIdentifierDeletionNotification
    }

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ValueOfEnum(NotificationTypeValue.class)
    private String type;

    @ManyToMany(mappedBy = "notificationTypes")
    private List<LccnSubscription> lccnSubscriptions;
}
