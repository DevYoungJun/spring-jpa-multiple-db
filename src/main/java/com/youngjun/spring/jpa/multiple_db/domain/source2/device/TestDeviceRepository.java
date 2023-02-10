package com.youngjun.spring.jpa.multiple_db.domain.source2.device;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDeviceRepository extends JpaRepository<TestDevice, Long> {

}
