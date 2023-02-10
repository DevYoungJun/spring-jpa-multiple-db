package com.youngjun.spring.jpa.multiple_db.domain.source2.device;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestDevice {

  public TestDevice() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "device_id", nullable = false)
  private Long id;

  @Column
  private String name;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
