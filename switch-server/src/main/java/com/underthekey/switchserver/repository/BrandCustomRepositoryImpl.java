package com.underthekey.switchserver.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.underthekey.switchserver.domain.QBrand;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BrandCustomRepositoryImpl implements BrandCustomRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<String> findBrandNames() {
		return queryFactory.selectFrom(QBrand.brand)
			.select(QBrand.brand.name)
			.fetch();
	}
}
