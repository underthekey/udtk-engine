package com.underthekey.switchserver.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.underthekey.switchserver.repository.BrandCustomRepository;
import com.underthekey.switchserver.repository.SwitchCustomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SwitchService {
	private final BrandCustomRepository brandRepository;
	private final SwitchCustomRepository switchRepository;

	public List<String> getBrands() {
		return brandRepository.findBrandNames();
	}
}
