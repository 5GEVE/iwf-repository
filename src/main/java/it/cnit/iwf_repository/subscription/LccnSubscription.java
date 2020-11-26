package it.cnit.iwf_repository.subscription;

import io.swagger.v3.oas.annotations.Hidden;
import it.cnit.iwf_repository.nfvo.NfvOrchestrator;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
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
    NsLcmOperationOccurrenceNotification,
    NsIdentifierCreationNotification,
    NsIdentifierDeletionNotification
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  private String callbackUri;

  @NotNull
  @Column(unique = true)
  private UUID nsInstanceId;

  @ElementCollection
  @CollectionTable(name = "notification_type")
  @Enumerated(EnumType.STRING)
  private Set<NotificationType> notificationTypes = Collections
      .singleton(NotificationType.NsLcmOperationOccurrenceNotification);

  @Hidden
  @ManyToMany
  private List<NfvOrchestrator> nfvOrchestrators;
}
