package com.youngjun.spring.jpa.multiple_db.web.auth;

import com.youngjun.spring.jpa.multiple_db.domain.source1.auth.AuthService;
import com.youngjun.spring.jpa.multiple_db.domain.source1.auth.TokenSet;
import com.youngjun.spring.jpa.multiple_db.web.auth.dto.SignInRequestBody;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping("/sign-in")
  @ApiOperation(value = "Sign in")
  public ResponseEntity<TokenSet> signIn(@Valid @RequestBody SignInRequestBody requestBody) {
    TokenSet tokenSet = authService.signIn(requestBody.getEmail(), requestBody.getPw());
    return ResponseEntity.ok(tokenSet);
  }
}
