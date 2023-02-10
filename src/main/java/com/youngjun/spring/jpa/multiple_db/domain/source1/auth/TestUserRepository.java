package com.youngjun.spring.jpa.multiple_db.domain.source1.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserRepository extends JpaRepository<TestUser, Long> {
  TestUser findByEmail(String email);
}
