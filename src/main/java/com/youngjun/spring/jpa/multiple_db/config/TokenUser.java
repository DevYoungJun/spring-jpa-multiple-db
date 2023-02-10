package com.youngjun.spring.jpa.multiple_db.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class TokenUser {
  private String id;

  public TokenUser(String id) {
    this.id = id;
  }

  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<String> roles = new ArrayList<>();
    roles.add("USER_ROLE");
    return roles.stream()
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());
  }
}
