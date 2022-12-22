package dev.ososuna.eazybank.util;

import java.util.Collections;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import dev.ososuna.eazybank.exception.NotFoundException;
import dev.ososuna.eazybank.model.Customer;
import dev.ososuna.eazybank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomerUtil {
  
  private final CustomerRepository customerRepository;
  
  public Customer getCustomerByEmail(String email) throws NotFoundException {
    return customerRepository.findByEmailAndActiveTrue(email)
      .orElseThrow(() -> new NotFoundException("User not found"));
  }

  public Optional<UserDetails> getUserDetailsByEmail(String email) {
    return customerRepository.findByEmailAndActiveTrue(email).map(
      customer -> new User(
        customer.getEmail(),
        customer.getPassword(),
        Collections.singletonList(new SimpleGrantedAuthority(customer.getRole()))
      )
    );
  }
}
