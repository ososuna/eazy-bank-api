package dev.ososuna.eazybank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="card")
public class Card extends AbstractModificationAttributesEntity {
  
  @JoinColumn(name="customer_id", nullable=false)
  @OneToOne
  private Customer customer;

  @Column(name="card_number", nullable=false)
  private String cardNumber;

  @Column(name="card_type", nullable=false)
  private String cardType;

  @Column(name="total_limit", nullable=false)
  private Double totalLimit;

  @Column(name="amount_used", nullable=false)
  private Double amountUsed;

  @Column(name="available_amount", nullable=false)
  private Double availableAmount;

}
