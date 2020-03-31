package it.cnit.siteinventory.subscription;

import it.cnit.siteinventory.nfvo.NfvOrchestrator;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class LccnSubscription {
    @Id
    @GeneratedValue
    private long id;

    private @NotNull String callbackUri;
    private @NotNull String nsInstanceId;
    private @NotNull String operation;
    private String lastOperationState;

    @ManyToOne
    private NfvOrchestrator nfvo;
}
