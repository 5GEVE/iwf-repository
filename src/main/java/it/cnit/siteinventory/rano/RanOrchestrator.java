package it.cnit.siteinventory.rano;

import it.cnit.siteinventory.cred.Credentials;
import it.cnit.siteinventory.site.Site;
import it.cnit.siteinventory.zone.RanZone;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class RanOrchestrator {
    @Id
    @GeneratedValue
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
