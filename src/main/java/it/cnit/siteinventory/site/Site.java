package it.cnit.siteinventory.site;

import io.swagger.annotations.ApiModelProperty;
import it.cnit.siteinventory.datashipper.DataShipper;
import it.cnit.siteinventory.network.Network;
import it.cnit.siteinventory.nfvo.NfvOrchestrator;
import it.cnit.siteinventory.rano.RanOrchestrator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Site {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  @Column(unique = true)
  private String name;

  @NotNull
  private String location;

  @NotNull
  @Pattern(regexp = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$",
      message = "must be a valid IPv4 address")
  private String kafkaIpAddress;

  @ApiModelProperty(hidden = true)
  @OneToMany(mappedBy = "site")
  private List<NfvOrchestrator> nfvOrchestrators;

  @ApiModelProperty(hidden = true)
  @OneToMany(mappedBy = "site")
  private List<RanOrchestrator> ranOrchestrators;

  @ApiModelProperty(hidden = true)
  @OneToMany(mappedBy = "site")
  private List<DataShipper> dataShippers;

  @ApiModelProperty(hidden = true)
  @OneToMany(mappedBy = "site")
  private List<Network> networks;
}
