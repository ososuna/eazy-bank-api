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
@Table(name="loan")
public class Loan extends AbstractModificationAttributesEntity {

  @JoinColumn(name="customer_id", nullable=false)
  @OneToOne
  private Customer customer;

  @Column(name="loan_type", nullable=false)
  private String loanType;

  @Column(name="loan_amount", nullable=false)
  private Double loanAmount;

  @Column(name="amount_paid", nullable=false)
  private Double amountPaid;

  @Column(name="outstanding_amount", nullable=false)
  private Double outstandingAmount;
  
}
