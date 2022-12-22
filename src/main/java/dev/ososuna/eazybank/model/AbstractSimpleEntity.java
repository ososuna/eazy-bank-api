package dev.ososuna.eazybank.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractSimpleEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(
    name="id",
    updatable=false,
    nullable=false,
    unique=true
  )
  private Long id;
}
