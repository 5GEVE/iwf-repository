package it.cnit.siteinventory;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class NfvoCredentials {

    @Id
    @GeneratedValue
    private long id;

    private @NotNull String host;
    private @NotNull String project;
    private @NotNull String user;
    private @NotNull String password;
}
