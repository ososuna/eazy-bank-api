package dev.ososuna.eazybank.model;

import java.time.LocalDate;

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
@Table(name="notice")
public class Notice extends AbstractModificationAttributesEntity {

  @Column(name="summary", nullable=false)
  private String summary;

  @Column(name="details", nullable=false)
  private String details;

  @Column(name="end_date", nullable=false)
  private LocalDate endDate;

}
