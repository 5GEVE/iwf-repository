package it.cnit.siteinventory.subscription;

import io.swagger.annotations.ApiModelProperty;
import it.cnit.siteinventory.nfvo.NfvOrchestrator;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class LccnSubscription {

  @SuppressWarnings("unused")
  public enum NotificationType {
    NsLcmOperationOccurenceNotification,
    NsIdentifierCreationNotification,
    NsIdentifierDeletionNotification
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  private String callbackUri;

  @NotNull
  private UUID nsInstanceId;

  @ElementCollection
  @Enumerated(EnumType.STRING)
  @CollectionTable(name = "notification_type")
  private Set<NotificationType> notificationTypes = Collections
      .singleton(NotificationType.NsLcmOperationOccurenceNotification);

  @ApiModelProperty(hidden = true)
  @ManyToMany
  private List<NfvOrchestrator> nfvOrchestrators;
}
