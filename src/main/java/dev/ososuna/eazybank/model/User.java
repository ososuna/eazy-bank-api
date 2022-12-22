package dev.ososuna.eazybank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="user")
public class User extends AbstractModificationAttributesEntity {
  @Column(name="username")
  private String username;

  @Column(name="password")
  private String password;

  @Column(name="authority")
  private String authority;
}
