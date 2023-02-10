package com.youngjun.spring.jpa.multiple_db.web.auth.dto;

import javax.validation.constraints.NotBlank;

public class SignInRequestBody {
  @NotBlank
  private String email;
  @NotBlank
  private String pw;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPw() {
    return pw;
  }

  public void setPw(String pw) {
    this.pw = pw;
  }
}
