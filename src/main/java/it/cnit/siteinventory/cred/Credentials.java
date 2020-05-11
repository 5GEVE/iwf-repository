package it.cnit.siteinventory.cred;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Data;

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
