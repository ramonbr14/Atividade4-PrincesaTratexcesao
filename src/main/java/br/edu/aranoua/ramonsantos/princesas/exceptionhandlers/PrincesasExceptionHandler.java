package br.edu.aranoua.ramonsantos.princesas.exceptionhandlers;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.edu.aranoua.ramonsantos.princesas.customerros.NonUniquePrincesaException;
import br.edu.aranoua.ramonsantos.princesas.customerros.PrincesaError;

@ControllerAdvice
public class PrincesasExceptionHandler extends ResponseEntityExceptionHandler {

	public PrincesasExceptionHandler() {
		// TODO Auto-generated constructor stub
	}

	
	@ExceptionHandler(NonUniquePrincesaException.class)
	public ResponseEntity<Object> handlerNonUniquePrincesaException(NonUniquePrincesaException ex, WebRequest request){
		HttpStatus myStatus = HttpStatus.BAD_REQUEST;
		String message = "Falta parâmetro";
		String error = ex.getMessage();
	
	
		PrincesaError princesaerror = new PrincesaError(myStatus, message, error);
		
		/*ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(princesaerror, new HttpHeaders(), myStatus);*/
		ResponseEntity<Object> responseEntity = handleExceptionInternal(ex, princesaerror, new HttpHeaders(), myStatus, request);
		return responseEntity;
		
	
	}
	
	@ExceptionHandler(PropertyValueException.class)
	public ResponseEntity<Object> handlerPropertyValueException(PropertyValueException ex, WebRequest request){
		HttpStatus myStatus = HttpStatus.BAD_REQUEST;
		String message = "Falta parâmetro";
		String error = ex.getMessage();
	
	
		PrincesaError princesaerror = new PrincesaError(myStatus, message, error);
		
		ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(princesaerror, new HttpHeaders(), myStatus);
		return responseEntity;
		
	
	}
	
	
	
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		HttpStatus myStatus = HttpStatus.BAD_REQUEST;
		String message = "Falta parâmetro";
		String error = "Falta preencher essa informação: " + ex.getParameterName();
		
		PrincesaError princesaerror = new PrincesaError(myStatus, message, error);
		
		ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(princesaerror, new HttpHeaders(), myStatus);
		
		return responseEntity;
	}

	
	
}
