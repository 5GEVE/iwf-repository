package it.cnit.nfvoservice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class NfvoCredentials {

    @Id
    private long id;
    @OneToOne
    @MapsId
    private Nfvo nfvo;

    private @NotNull String host;
    private @NotNull String project;
    private @NotNull String user;
    private @NotNull String password;
}
