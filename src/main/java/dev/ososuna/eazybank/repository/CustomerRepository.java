package dev.ososuna.eazybank.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.ososuna.eazybank.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
  Optional<Customer> findByEmailAndActiveTrue(String email);
}
