package com.nelioalves.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice	// classe para controle de erro proveniente das requisições
public class ResourceExceptionHandler {

	// indica para o spring retornar o erro 404 (not found) para o browser quando ocorrer a ObjectNotFoundException
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(System.currentTimeMillis(),
												status.value(),
												"Não encontrado",
												exception.getMessage(),
												request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}
}
