package it.cnit.iwf_repository.area;

import io.swagger.v3.oas.annotations.Hidden;
import it.cnit.iwf_repository.rano.RanOrchestrator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class CoverageArea {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  private String name;

  private double latitude;

  private double longitude;

  private double radius;

  // 4G, 5G
  @Min(4)
  private int generation;

  // Ex. R16
  private String release;

  // comma-separated list of strings
  private String frequencies;

  @Hidden
  @ManyToOne
  private RanOrchestrator ranOrchestrator;

  // TODO add more RAN capabilities
}
