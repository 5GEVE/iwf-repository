package it.cnit.siteinventory.datashipper;

import io.swagger.annotations.ApiModelProperty;
import it.cnit.siteinventory.site.Site;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
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
  private String deviceId;

  @NotNull
  private String ipAddress;

  @NotNull
  @Enumerated(EnumType.STRING)
  private InfrastructureMetricType metricType;

  private String username;

  private String publicKey;

  @ApiModelProperty(hidden = true)
  @ManyToOne
  private Site site;
}
