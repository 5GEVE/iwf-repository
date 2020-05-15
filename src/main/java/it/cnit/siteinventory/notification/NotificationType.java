package it.cnit.siteinventory.notification;

import it.cnit.siteinventory.constraints.ValueOfEnum;
import it.cnit.siteinventory.subscription.LccnSubscription;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import lombok.Data;

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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @ValueOfEnum(NotificationTypeValue.class)
  private String type;

  @ManyToMany(mappedBy = "notificationTypes")
  private List<LccnSubscription> subscriptions;
}
