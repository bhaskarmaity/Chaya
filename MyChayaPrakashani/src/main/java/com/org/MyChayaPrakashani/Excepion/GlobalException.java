package com.org.MyChayaPrakashani.Excepion;


import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ExceptionDetails er= new ExceptionDetails(new Date(),"Validation error",
				ex.getBindingResult().getFieldError().getDefaultMessage(),request.getDescription(false));
		
		return new ResponseEntity<Object>(er,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionDetails er= new ExceptionDetails(new Date(),"Not Found Exception",
				ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(er,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RegistrationFailedException.class)
	public final ResponseEntity<Object> handleRegistrationFailedExceptionxception(Exception ex, WebRequest request) throws Exception {
		ExceptionDetails er= new ExceptionDetails(new Date(),"Failed Exception",
				ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(er,HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(DuplicateEntryException.class)
	public final ResponseEntity<Object> handleDuplicateEntryException(Exception ex, WebRequest request) throws Exception {
		ExceptionDetails er= new ExceptionDetails(new Date(),"Duplicate Enty Exception",
				ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(er,HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(IllegalSortingValueException.class)
	public final ResponseEntity<Object> handleIllegalSortingValueException(Exception ex, WebRequest request) throws Exception {
		ExceptionDetails er= new ExceptionDetails(new Date(),"Illegal Sorting Value Exception",
				ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(er,HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(PagingException.class)
	public final ResponseEntity<Object> handlePagingException(Exception ex, WebRequest request) throws Exception {
		ExceptionDetails er= new ExceptionDetails(new Date(),"Something went to wrong in context of paging",
				ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(er,HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(InvalidRoleException.class)
	public final ResponseEntity<Object> handleInvalidRoleException(Exception ex, WebRequest request) throws Exception {
		ExceptionDetails er= new ExceptionDetails(new Date(),"Something went to wrong Role",
				ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(er,HttpStatus.EXPECTATION_FAILED);
	}	
} 