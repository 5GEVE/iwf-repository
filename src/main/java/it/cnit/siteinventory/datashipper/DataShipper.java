package it.cnit.siteinventory.datashipper;

import io.swagger.annotations.ApiModelProperty;
import it.cnit.siteinventory.site.Site;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class DataShipper {

  @SuppressWarnings("unused")
  public enum InfrastructureMetricType {
    LOST_PKT,
    RECEIVED_PKT,
    SENT_PKT,
    BANDWIDTH,
    LATENCY,
    JITTER,
    CPU_CONSUMPTION,
    MEMORY_CONSUMPTION,
    OTHER
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  @Column(unique = true)
  private String dataShipperId;

  @NotNull
  @Pattern(regexp = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$",
      message = "must be a valid IPv4 address")
  private String ipAddress;

  @NotNull
  private String username;

  private String password;

  @NotNull
  private String configurationScript;

  @NotNull
  private String stopConfigScript;

  @Enumerated(EnumType.STRING)
  private InfrastructureMetricType metricType;

  @ApiModelProperty(hidden = true)
  @ManyToOne
  private Site site;
}
