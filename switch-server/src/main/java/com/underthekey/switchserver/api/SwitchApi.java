package com.underthekey.switchserver.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.underthekey.switchserver.service.SwitchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/switch")
@RequiredArgsConstructor
public class SwitchApi {
	private final SwitchService switchService;

	@GetMapping("/brands")
	public List<String> getBrands() {
		return switchService.getBrands();
	}
}
