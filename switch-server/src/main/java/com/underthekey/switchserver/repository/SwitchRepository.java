package com.underthekey.switchserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.underthekey.switchserver.domain.Switch;

@Repository
public interface SwitchRepository extends JpaRepository<Switch, Long>, SwitchCustomRepository {
}
