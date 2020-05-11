package it.cnit.siteinventory.zone;

import it.cnit.siteinventory.constraints.ValueOfEnum;
import it.cnit.siteinventory.vim.VimAccount;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class AvailabilityZone {
    @SuppressWarnings("unused")
    enum Location {
        CLOUD,
        EDGE
    }

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    @NotNull
    @ValueOfEnum(value = Location.class, enumStrings = {"CLOUD", "EDGE"})
    private String location = Location.CLOUD.name();

    private double latitude;

    private double longitude;

    @OneToOne
    private VimAccount vimAccount;
}
