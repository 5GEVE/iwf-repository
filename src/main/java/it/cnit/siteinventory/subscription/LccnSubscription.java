package it.cnit.siteinventory.subscription;

import it.cnit.siteinventory.nfvo.NfvOrchestrator;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class LccnSubscription {
    @Id
    @GeneratedValue
    private long id;

    private @NotNull String callbackUri;
    private @NotNull String nsInstanceId;

    @ManyToMany
    private List<NfvOrchestrator> nfvos;
}
