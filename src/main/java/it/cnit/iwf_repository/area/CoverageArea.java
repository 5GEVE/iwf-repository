package it.cnit.iwf_repository.area;

import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
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
    LTE_M("LTE-M"),
    _5GmmWave("5GmmWave");

    @JsonValue
    public final String label;

    @Override
    public String toString() {
      return label;
    }
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  @Schema(example = "ITALY.TIM_LAB")
  private String name;

  @ElementCollection
  @CollectionTable(name = "radio_access_technology")
  @Enumerated(EnumType.STRING)
  private Set<RadioAccessTechnology> radioAccessTechnologies;

  @Schema(example = "45.0740984")
  private double latitude;

  @Schema(example = "7.6304583")
  private double longitude;

  @Schema(description = "The radius of the coverage area in Kilometers", example = "1.5")
  private double radius;

  @ElementCollection
  @CollectionTable(name = "radio_frequencies")
  @Schema(description = "Radio frequencies supported",
      example = "[ \"50MHz\", \"800MHz\", \"6GHz\" ]")
  private Set<String> frequencies;

  @Hidden
  @ManyToOne
  private RanOrchestrator ranOrchestrator;

}
