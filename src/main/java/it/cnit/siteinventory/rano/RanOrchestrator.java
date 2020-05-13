package it.cnit.siteinventory.rano;

import it.cnit.siteinventory.cred.Credentials;
import it.cnit.siteinventory.site.Site;
import it.cnit.siteinventory.zone.RanZone;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@Data
public class RanOrchestrator {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  private String name;

  @NotNull
  private String type;

  private String uri;

  @OneToOne(cascade = CascadeType.ALL)
  @RestResource(exported = false)
  private Credentials credentials;

  @ManyToOne
  private Site site;

  @OneToMany(mappedBy = "rano")
  private List<RanZone> ranZones;
}
