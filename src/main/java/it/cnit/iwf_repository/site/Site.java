package it.cnit.iwf_repository.site;

import io.swagger.annotations.ApiModelProperty;
import it.cnit.iwf_repository.datashipper.DataShipper;
import it.cnit.iwf_repository.kafkaendpoint.KafkaEndPoint;
import it.cnit.iwf_repository.network.Network;
import it.cnit.iwf_repository.nfvo.NfvOrchestrator;
import it.cnit.iwf_repository.rano.RanOrchestrator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.data.rest.core.annotation.RestResource;
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

  @OneToOne(cascade = CascadeType.ALL)
  @RestResource(exported = false)
  private KafkaEndPoint kafkaendpoint;

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
