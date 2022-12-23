package dev.ososuna.eazybank.configuration;

import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.ososuna.eazybank.model.Customer;
import dev.ososuna.eazybank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

  private final PasswordEncoder passwordEncoder;
  private final CustomerRepository customerRepository;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    final String email = authentication.getName();
    final String password = authentication.getCredentials().toString();
    final Optional<Customer> customerOptional = customerRepository.findByEmailAndActiveTrue(email);
    if (customerOptional.isPresent()) {
      final Customer customer = customerOptional.get();
      if (passwordEncoder.matches(password, customer.getPassword())) {
        return new UsernamePasswordAuthenticationToken(email, password, List.of(() -> customer.getRole()));
      }
    }
    throw new BadCredentialsException("Invalid username or password");
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
  }
  
}
