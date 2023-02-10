package com.youngjun.spring.jpa.multiple_db.web.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  @GetMapping("")
  public ResponseEntity list() {
    return ResponseEntity.noContent().build();
  }
}
