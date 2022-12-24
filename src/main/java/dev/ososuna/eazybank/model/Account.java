package dev.ososuna.eazybank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="account")
public class Account extends AbstractModificationAttributesEntity {

  @JoinColumn(name="customer_id", nullable=false)
  @ManyToOne
  private Customer customer;

  @Column(name="account_type", nullable=false)
  private String accountType;

  @Column(name="branch_address", nullable=false)
  private String branchAddress;

}
