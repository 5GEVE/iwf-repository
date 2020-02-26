package it.cnit.nfvoservice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Nfvo {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String nfvoType;
    @NotNull
    private String site;
    private String url;
}
