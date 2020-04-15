package it.cnit.siteinventory.zone;

import it.cnit.siteinventory.constraints.ValueOfEnum;
import it.cnit.siteinventory.vim.Vim;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

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

    @ValueOfEnum(value = Location.class, enumStrings = {"CLOUD", "EDGE"})
    private String location = "CLOUD";

    private double latitude;

    private double longitude;

    @ManyToOne
    private Vim vim;
}
