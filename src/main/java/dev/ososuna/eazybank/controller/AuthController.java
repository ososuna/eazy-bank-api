package dev.ososuna.eazybank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.ososuna.eazybank.exception.BadRequestException;
import dev.ososuna.eazybank.model.Customer;
import dev.ososuna.eazybank.model.dto.RegisterRequest;
import dev.ososuna.eazybank.service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {
  
  private final AuthService authService;

  @PostMapping("/register")
  public ResponseEntity<Customer> register(@RequestBody RegisterRequest request) throws BadRequestException {
    return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(request));
  }
}
