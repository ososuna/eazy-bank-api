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
@Table(name="customer")
public class Customer extends AbstractModificationAttributesEntity {
  
  @Column(name="email", unique=true, nullable=false)
  private String email;

  @Column(name="password", nullable=false)
  private String password;

  @Column(name="role", nullable=false)
  private String role;
}
