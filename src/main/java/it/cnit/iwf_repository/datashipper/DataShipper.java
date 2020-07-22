package it.cnit.iwf_repository.datashipper;

import io.swagger.annotations.ApiModelProperty;
import it.cnit.iwf_repository.site.Site;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
  @Column(columnDefinition = "TEXT")
  private String configurationScript;

  @NotNull
  @Column(columnDefinition = "TEXT")
  private String stopConfigScript;

  @Enumerated(EnumType.STRING)
  private InfrastructureMetricType metricType;

  @ApiModelProperty(hidden = true)
  @ManyToOne
  private Site site;

  @PrePersist
  @PreUpdate
  private void updateDataShipperId() {
    String siteName;
    if (this.site == null) {
      siteName = "<no_site>";
    } else {
      siteName = this.site.getName();
    }
    this.dataShipperId = String.join(".", siteName, this.metricType.name(), "custom_id");
  }
}
