package com.underthekey.common.exception;

import static com.underthekey.common.exception.ErrorCode.*;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BaseException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(BaseException exception) {
		return ResponseEntity.status(exception.getErrorCode().getHttpStatus())
			.body(new ErrorResponse(exception.getErrorCode().getHttpStatus().value(),
				exception.getErrorCode().getErrorMsg()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
		MethodArgumentNotValidException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new ErrorResponse(METHOD_ARGUMENT_NOT_VALID.getHttpStatus().value(), Objects.requireNonNull(
				exception.getFieldError()).getDefaultMessage()));
	}
}
