package com.simplepicpay.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.simplepicpay.dtos.ExceptionDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity handleDuplicateEntry(DataIntegrityViolationException e) {
		ExceptionDTO exceptionDTO = new ExceptionDTO("User already exists", "400");
		return ResponseEntity.badRequest().body(exceptionDTO);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity handleEntityNotFound(EntityNotFoundException e) {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleGeneralException(Exception e) {
		ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(), "500");
		return ResponseEntity.internalServerError().body(exceptionDTO);
	}
}
