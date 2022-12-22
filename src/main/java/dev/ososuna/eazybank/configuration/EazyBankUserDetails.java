package dev.ososuna.eazybank.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.ososuna.eazybank.util.CustomerUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EazyBankUserDetails implements UserDetailsService {

  private final CustomerUtil customerUtil;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return customerUtil.getUserDetailsByEmail(username)
      .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

}
