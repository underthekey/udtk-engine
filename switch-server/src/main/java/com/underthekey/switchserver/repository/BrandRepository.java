package com.underthekey.switchserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.underthekey.switchserver.domain.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>, BrandCustomRepository {
}
