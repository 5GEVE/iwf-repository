package it.cnit.siteinventory.subscription;

import it.cnit.siteinventory.nfvo.NfvOrchestrator;
import it.cnit.siteinventory.notification.NotificationType;
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
public class LccnSubscription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  private String callbackUri;

  @NotNull
  private String nsInstanceId;

  @ManyToMany
  private List<NotificationType> notificationTypes;

  @ManyToMany
  private List<NfvOrchestrator> nfvOrchestrators;
}
