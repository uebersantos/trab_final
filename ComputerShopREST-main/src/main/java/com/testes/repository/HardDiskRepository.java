package com.testes.repository;

import com.testes.entity.HardDisk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HardDiskRepository extends JpaRepository<HardDisk, Long> {
}
