package it.cnit.iwf_repository.area;

import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.Hidden;
import it.cnit.iwf_repository.rano.RanOrchestrator;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
public class CoverageArea {

  @SuppressWarnings("unused")
  @RequiredArgsConstructor
  public enum RadioAccessTechnology {
    // TODO recheck with Marc
    _4G("4G"),
    _5GNSA("5GNSA"),
    _5GSA("5GSA"),
    NB_IOT("NB-IoT"),
    LTE_M("LTE-M");

    @JsonValue
    public final String label;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  private String name;

  @ElementCollection
  @CollectionTable(name = "radio_access_technology")
  @Enumerated(EnumType.STRING)
  private Set<RadioAccessTechnology> radioAccessTechnologies;

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
