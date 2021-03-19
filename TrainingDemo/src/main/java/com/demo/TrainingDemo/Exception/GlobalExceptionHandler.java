package com.demo.TrainingDemo.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	// handle specific exception
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException exception, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	// handle specific exception
		@ExceptionHandler(APIException.class)
		public ResponseEntity<?> handleAPIException(APIException exception, WebRequest request){
			ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
			return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
		}
	
	// handle global Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// handle input validation Exception
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleInputValidationException(MethodArgumentNotValidException exception, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "Input Validation Exception", exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity(errorDetails,HttpStatus.NOT_ACCEPTABLE);
	}
}
