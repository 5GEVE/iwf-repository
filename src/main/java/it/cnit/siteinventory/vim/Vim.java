package it.cnit.siteinventory.vim;

import it.cnit.siteinventory.nfvo.NfvOrchestrator;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Vim {

    @Id
    @GeneratedValue
    private long id;

    private @NotNull String name;
    private @NotNull String type;
    private String uri;

    @ManyToOne
    private NfvOrchestrator nfvo;
}
