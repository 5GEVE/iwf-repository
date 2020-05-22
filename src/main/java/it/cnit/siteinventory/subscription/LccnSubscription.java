package it.cnit.siteinventory.subscription;

import io.swagger.annotations.ApiModelProperty;
import it.cnit.siteinventory.nfvo.NfvOrchestrator;
import java.util.List;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
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
  private String nsInstanceId;

  @ElementCollection
  @CollectionTable(name = "notification_type")
  private Set<NotificationType> notificationTypes;

  @ApiModelProperty(hidden = true)
  @ManyToMany
  private List<NfvOrchestrator> nfvOrchestrators;
}
