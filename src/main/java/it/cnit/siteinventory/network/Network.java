package it.cnit.siteinventory.network;

import io.swagger.annotations.ApiModelProperty;
import it.cnit.siteinventory.site.Site;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Network {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  private String vimNetworkName;

  @NotNull
  private boolean floatingIp;

  @NotNull
  private boolean management;

  @Pattern(regexp = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])(/(\\d|[1-2]\\d|3[0-2]))$",
      message = "must be a valid IPv4 address range (ex. 192.168.1.0/24)")
  private String cidr;

  @ApiModelProperty(hidden = true)
  @ManyToOne
  private Site site;
}
