package it.cnit.siteinventory.rano;

import it.cnit.siteinventory.site.Site;
import it.cnit.siteinventory.vim.Vim;
import lombok.Data;

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

    @ManyToOne
    private Site site;

    @ManyToMany(mappedBy = "ranos")
    private List<Vim> vims;
}
