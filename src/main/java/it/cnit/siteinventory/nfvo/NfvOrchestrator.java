package it.cnit.siteinventory.nfvo;

import it.cnit.siteinventory.constraints.ValueOfEnum;
import it.cnit.siteinventory.cred.Credentials;
import it.cnit.siteinventory.site.Site;
import it.cnit.siteinventory.subscription.LccnSubscription;
import it.cnit.siteinventory.vim.Vim;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity
@Data
public class NfvOrchestrator {
    @SuppressWarnings("unused")
    enum OperationalState {
        ENABLED,
        DISABLED
    }

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private String version;

    @NotNull
    @ValueOfEnum(OperationalState.class)
    private String operationalState = OperationalState.ENABLED.name();

    private String uri;

    private Date createdAt;

    private Date updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @RestResource(exported = false)
    private Credentials credentials;

    @ManyToMany(mappedBy = "nfvos")
    private List<Vim> vims;

    @ManyToMany(mappedBy = "nfvos")
    private List<LccnSubscription> subscriptions;

    @ManyToOne
    private Site site;
}
