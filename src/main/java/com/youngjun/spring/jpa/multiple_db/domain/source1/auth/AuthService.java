package com.youngjun.spring.jpa.multiple_db.domain.source1.auth;

public interface AuthService {
  TokenSet signIn(String id, String pw);
}
