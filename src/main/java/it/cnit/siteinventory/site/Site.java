package it.cnit.siteinventory.site;

import it.cnit.siteinventory.datashipper.DataShipper;
import it.cnit.siteinventory.nfvo.NfvOrchestrator;
import it.cnit.siteinventory.rano.RanOrchestrator;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Site {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String location;

    @OneToMany(mappedBy = "site")
    private List<NfvOrchestrator> nfvos;

    @OneToMany(mappedBy = "site")
    private List<RanOrchestrator> ranos;

    @OneToMany(mappedBy = "site")
    private List<DataShipper> dataShippers;
}
