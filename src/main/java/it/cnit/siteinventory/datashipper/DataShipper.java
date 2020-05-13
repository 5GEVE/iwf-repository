package it.cnit.siteinventory.datashipper;

import it.cnit.siteinventory.constraints.ValueOfEnum;
import it.cnit.siteinventory.site.Site;
import javax.persistence.Entity;
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
  @ValueOfEnum(InfrastructureMetricType.class)
  private String metricType;

  private String username;

  private String publicKey;

  @ManyToOne
  private Site site;
}
