package it.cnit.siteinventory.cred;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Credentials {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String host;

    @NotNull
    private String project;

    @NotNull
    private String username;

    @NotNull
    private String password;
}
