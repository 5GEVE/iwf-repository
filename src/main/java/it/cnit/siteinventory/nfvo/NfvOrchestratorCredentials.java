package it.cnit.siteinventory.nfvo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class NfvOrchestratorCredentials {

    @Id
    @GeneratedValue
    private long id;

    private @NotNull String host;
    private @NotNull String project;
    private @NotNull String username;
    private @NotNull String password;
}
