package it.cnit.siteinventory.cred;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import lombok.Data;

@Entity
@Data
public class Credentials {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String host;

  @NotNull
  @PositiveOrZero
  @Max(65535)
  private long port;

  @NotNull
  private String project;

  @NotNull
  private String username;

  @NotNull
  private String password;
}
