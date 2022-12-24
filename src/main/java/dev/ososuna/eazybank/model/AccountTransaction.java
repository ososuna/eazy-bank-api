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
@Table(name="account_transaction")
public class AccountTransaction extends AbstractModificationAttributesEntity {

  @JoinColumn(name="account_id", nullable=false)
  @OneToOne
  private Account account;

  @JoinColumn(name="customer_id", nullable=false)
  @OneToOne
  private Customer customer;

  @Column(name="transaction_type", nullable=false)
  private String transactionType;
  
  @Column(name="transaction_summary", nullable=false)
  private String transactionSummary;

  @Column(name="amount", nullable=false)
  private Double amount;
}
