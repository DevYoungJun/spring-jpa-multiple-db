package com.youngjun.spring.jpa.multiple_db.domain.source1.auth;

public class TokenSet {
  private String accessToken;

  public TokenSet(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getAccessToken() {
    return accessToken;
  }
}
