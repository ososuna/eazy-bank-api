package dev.ososuna.eazybank.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractNamedEntity extends AbstractModificationAttributesEntity {
  @Column
  private String name;
}
