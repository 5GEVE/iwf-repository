package it.cnit.iwf_repository.vim;

import io.swagger.annotations.ApiModelProperty;
import it.cnit.iwf_repository.nfvo.NfvOrchestrator;
import it.cnit.iwf_repository.zone.AvailabilityZone;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class VimAccount {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  // This is the id used by the NVFO for this VIM account
  @NotNull
  @Column(unique = true)
  private UUID vimAccountNfvoId;

  @NotNull
  private String name;

  @NotNull
  private String type;

  private String uri;

  private String tenant;

  @ApiModelProperty(hidden = true)
  @OneToOne(mappedBy = "vimAccount")
  private AvailabilityZone availabilityZone;

  @ApiModelProperty(hidden = true)
  @ManyToMany
  @JoinTable(name = "vim_nfvo",
      joinColumns = @JoinColumn(name = "vim_id"),
      inverseJoinColumns = @JoinColumn(name = "nfvo_id"))
  private List<NfvOrchestrator> nfvOrchestrators;

}
