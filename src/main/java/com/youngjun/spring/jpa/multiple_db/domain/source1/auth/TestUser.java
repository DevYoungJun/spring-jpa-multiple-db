package com.youngjun.spring.jpa.multiple_db.domain.source1.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestUser {

  public TestUser() {}

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id", nullable = false)
  private Long id;

  @Column
  private String email;

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }
}
