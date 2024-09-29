package com.underthekey.switchserver.dto;

import lombok.Builder;

@Builder
public record SwitchDto(
	String switchType,
	String actuationForce,
	String preTravel,
	String totalTravel,
	String topHousingMaterial,
	String bottomHousingMaterial,
	String stemMaterial,
	String mount,
	Boolean smdLedSupport
) {
}
