package it.cnit.siteinventory.zone;

import it.cnit.siteinventory.rano.RanOrchestrator;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class RanZone {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    private double latitude;

    private double longitude;

    @ManyToOne
    private RanOrchestrator rano;

    // TODO add RAN capabilities
}
