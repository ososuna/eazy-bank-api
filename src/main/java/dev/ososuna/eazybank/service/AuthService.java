package dev.ososuna.eazybank.service;

import java.time.LocalDate;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.ososuna.eazybank.exception.BadRequestException;
import dev.ososuna.eazybank.model.Customer;
import dev.ososuna.eazybank.model.Role;
import dev.ososuna.eazybank.model.dto.RegisterRequest;
import dev.ososuna.eazybank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final PasswordEncoder passwordEncoder;
  private final CustomerRepository customerRepository;

  public Customer register(RegisterRequest request) throws BadRequestException {
    if (request.getPassword().length() < 6) {
      throw new BadRequestException("Password must be at least 6 characters");
    }
    if (customerRepository.existsByEmailAndActiveTrue(request.getEmail())) {
      throw new BadRequestException("User already exists");
    }
    final Customer customer = new Customer();
    customer.setEmail(request.getEmail());
    customer.setPassword(passwordEncoder.encode(request.getPassword()));
    customer.setActive(true);
    customer.setRole(Role.ROLE_USER.toString());
    customer.setCreatedBy(request.getEmail());
    customer.setCreatedDate(LocalDate.now());
    return customerRepository.save(customer);
  }
}
