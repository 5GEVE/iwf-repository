package it.cnit.siteinventory.site;

import it.cnit.siteinventory.datashipper.DataShipper;
import it.cnit.siteinventory.nfvo.NfvOrchestrator;
import it.cnit.siteinventory.rano.RanOrchestrator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Site {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  private String name;

  @NotNull
  private String location;

  @OneToMany(mappedBy = "site")
  private List<NfvOrchestrator> nfvOrchestrators;

  @OneToMany(mappedBy = "site")
  private List<RanOrchestrator> ranOrchestrators;

  @OneToMany(mappedBy = "site")
  private List<DataShipper> dataShippers;
}
