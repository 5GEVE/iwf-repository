package it.cnit.siteinventory.vim;

import it.cnit.siteinventory.constraints.ValueOfEnum;
import it.cnit.siteinventory.nfvo.NfvOrchestrator;
import it.cnit.siteinventory.rano.RanOrchestrator;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Vim {
    enum Location {
        CLOUD,
        EDGE;
    }

    @Id
    @GeneratedValue
    private long id;

    private @NotNull String name;
    private @NotNull String type;
    private String uri;
    private @ValueOfEnum(value = Location.class, enumStrings = {"CLOUD", "EDGE"}) String location;
    private double latitude;
    private double longitude;

    @ManyToMany
    @JoinTable(name = "vim_nfvo",
            joinColumns = @JoinColumn(name = "vim_id"),
            inverseJoinColumns = @JoinColumn(name = "nfvo_id"))
    private List<NfvOrchestrator> nfvos;

    @ManyToMany
    @JoinTable(name = "vim_rano",
            joinColumns = @JoinColumn(name = "vim_id"),
            inverseJoinColumns = @JoinColumn(name = "rano_id"))
    private List<RanOrchestrator> ranos;
}
