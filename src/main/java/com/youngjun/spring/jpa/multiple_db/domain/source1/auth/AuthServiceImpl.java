package com.youngjun.spring.jpa.multiple_db.domain.source1.auth;

import com.youngjun.spring.jpa.multiple_db.config.TokenProvider;
import com.youngjun.spring.jpa.multiple_db.domain.source2.device.TestDevice;
import com.youngjun.spring.jpa.multiple_db.domain.source2.device.TestDeviceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthServiceImpl implements AuthService{
  private final TokenProvider tokenProvider;
  private final TestUserRepository testUserRepository;
  private final TestDeviceRepository testDeviceRepository;
  private final long ACCESS_TOKEN_VALID_TIME = 24 * 60 * 60 * 1000L; // 임시값 24시간.

  public AuthServiceImpl(TokenProvider tokenProvider, TestUserRepository testUserRepository, TestDeviceRepository testDeviceRepository) {
    this.tokenProvider = tokenProvider;
    this.testUserRepository = testUserRepository;
    this.testDeviceRepository = testDeviceRepository;
  }

  @Override
  @Transactional
  public TokenSet signIn(String email, String pw) {
    // TODO: 사용자 인증처리
    TestUser testUser = testUserRepository.findByEmail(email);
    TestDevice testDevice = testDeviceRepository.findById(1L).orElseThrow(() -> new RuntimeException());

    // Token
    String tokenUid = email; // TODO: 적합한 값으로 교체
    String accessToken = tokenProvider.generateToken(tokenUid, "ROLE_USER", ACCESS_TOKEN_VALID_TIME);
    return new TokenSet(accessToken);
  }
}
