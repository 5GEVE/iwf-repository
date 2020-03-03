package it.cnit.siteinventory;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Vim {

    @Id
    @GeneratedValue
    private long id;

    private @NotNull String name;
    private @NotNull String type;

    @ManyToOne
    @JoinColumn(name = "nfvo_id", nullable = false)
    private Nfvo nfvo;
}
