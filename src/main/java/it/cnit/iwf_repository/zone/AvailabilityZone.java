package it.cnit.iwf_repository.zone;

import io.swagger.v3.oas.annotations.Hidden;
import it.cnit.iwf_repository.vim.VimAccount;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class AvailabilityZone {

  @SuppressWarnings("unused")
  enum Placement {
    CLOUD,
    EDGE
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  private String name;

  @NotNull
  @Enumerated(EnumType.STRING)
  private Placement placement = Placement.CLOUD;

  private double latitude;

  private double longitude;

  @Hidden
  @OneToOne
  private VimAccount vimAccount;
}
