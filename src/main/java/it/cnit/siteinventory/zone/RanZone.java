package it.cnit.siteinventory.zone;

import it.cnit.siteinventory.rano.RanOrchestrator;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
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

    private double radius;

    // 4G, 5G
    @Min(4)
    private int generation;

    // Ex. R16
    private String release;

    // comma-separated list of strings
    private String frequencies;

    @ManyToOne
    private RanOrchestrator rano;

    // TODO add more RAN capabilities
}
