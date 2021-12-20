package br.edu.aranoua.ramonsantos.princesas.customerros;

public class NonUniquePrincesaException extends RuntimeException {
	
	static String unicamensagem = "PRINCESA JA EXISTE NO BANCO DE DADOS!";
	private static final long serialVersionUID = 1L;
	
	public NonUniquePrincesaException() {
		// TODO Auto-generated constructor stub
	}

	public NonUniquePrincesaException(String message) {
		super(unicamensagem);
		// TODO Auto-generated constructor stub
	}

	public NonUniquePrincesaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NonUniquePrincesaException(String message, Throwable cause) {
		super(unicamensagem, cause);
		// TODO Auto-generated constructor stub
	}

	public NonUniquePrincesaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(unicamensagem, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
