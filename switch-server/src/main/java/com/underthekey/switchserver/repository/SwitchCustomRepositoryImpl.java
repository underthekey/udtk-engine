package com.underthekey.switchserver.repository;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SwitchCustomRepositoryImpl implements SwitchCustomRepository {
	private final JPAQueryFactory queryFactory;

}
