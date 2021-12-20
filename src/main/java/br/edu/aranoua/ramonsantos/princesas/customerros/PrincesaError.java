package br.edu.aranoua.ramonsantos.princesas.customerros;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class PrincesaError {

	private HttpStatus status;
	private String message;
	private List<String> errors;
	
	public PrincesaError(HttpStatus status, String message, List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}
	
	public PrincesaError(HttpStatus status, String message, String error) {
		super();
		this.status = status;
		this.message = message;
		this.errors = Arrays.asList(error);
	}
	
	
	
	
	
	
	
	

}
