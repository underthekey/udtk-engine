package com.underthekey.common.exception;

import lombok.Builder;

@Builder
public record ErrorResponse(
	int httpStatus,
	String errorMsg
) {
}
