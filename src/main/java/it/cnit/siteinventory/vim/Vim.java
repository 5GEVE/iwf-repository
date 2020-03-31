package it.cnit.siteinventory.vim;

import it.cnit.siteinventory.nfvo.Nfvo;
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
    private Nfvo nfvo;
}
