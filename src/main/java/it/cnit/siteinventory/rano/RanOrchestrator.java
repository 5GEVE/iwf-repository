package it.cnit.siteinventory.rano;

import it.cnit.siteinventory.site.Site;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class RanOrchestrator {
    @Id
    @GeneratedValue
    private long id;

    private @NotNull String name;
    private @NotNull String type;
    private String uri;

    @ManyToOne
    private Site site;
}
