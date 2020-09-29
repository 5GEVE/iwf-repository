package it.cnit.iwf_repository.nfvo;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import it.cnit.iwf_repository.cred.Credentials;
import it.cnit.iwf_repository.site.Site;
import it.cnit.iwf_repository.subscription.LccnSubscription;
import it.cnit.iwf_repository.vim.VimAccount;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@Data
public class NfvOrchestrator {

  @SuppressWarnings("unused")
  enum OperationalState {
    ENABLED,
    DISABLED
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  @Column(unique = true)
  private String name;

  @NotNull
  private String type;

  @NotNull
  private String version;

  @NotNull
  @Enumerated(EnumType.STRING)
  private OperationalState operationalState = OperationalState.ENABLED;

  private String uri;

  private Date createdAt;

  private Date updatedAt;

  @OneToOne(cascade = CascadeType.ALL)
  @RestResource(exported = false)
  private Credentials credentials;

  @Hidden
  @ManyToMany(mappedBy = "nfvOrchestrators")
  private List<VimAccount> vimAccounts;

  @Hidden
  @ManyToMany(mappedBy = "nfvOrchestrators")
  private List<LccnSubscription> subscriptions;

  @Hidden
  @ManyToOne
  private Site site;
}
