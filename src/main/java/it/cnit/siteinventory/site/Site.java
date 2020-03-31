package it.cnit.siteinventory.site;

import it.cnit.siteinventory.nfvo.Nfvo;
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

    private @NotNull String name;
    private @NotNull String location;

    @OneToMany(mappedBy = "site")
    private List<Nfvo> nfvos;
}
