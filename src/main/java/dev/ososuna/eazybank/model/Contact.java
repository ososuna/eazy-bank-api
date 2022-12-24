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
@Table(name="contact")
public class Contact extends AbstractModificationAttributesEntity {
  
  @Column(name="name", nullable=false)
  private String name;

  @Column(name="email", nullable=false)
  private String email;

  @Column(name="subject", nullable=false)
  private String subject;

  @Column(name="message", nullable=false)
  private String message;

}
