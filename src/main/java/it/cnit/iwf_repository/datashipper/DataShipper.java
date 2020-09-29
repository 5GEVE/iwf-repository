package it.cnit.iwf_repository.datashipper;

import io.swagger.v3.oas.annotations.Hidden;
import it.cnit.iwf_repository.site.Site;
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
    USER_DATA_RATE_DOWNLINK,
    USER_DATA_RATE_UPLINK,
    CAPACITY,
    LATENCY_USERPLANE,
    LATENCY_CONTROLPLANE,
    DEVICE_DENSITY,
    MOBILITY
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
  @Column(columnDefinition="TEXT")
  private String configurationScript;

  @NotNull
  @Column(columnDefinition="TEXT")
  private String stopConfigScript;

  @Enumerated(EnumType.STRING)
  private InfrastructureMetricType metricType;

  @Hidden
  @ManyToOne
  private Site site;
}
