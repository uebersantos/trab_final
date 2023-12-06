package com.testes.repository;

import com.testes.entity.Desktop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesktopRepository extends JpaRepository<Desktop, Long> {
}
