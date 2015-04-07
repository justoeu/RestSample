package br.com.justoeu.infrastructure.exception;

public class APIException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public APIException(int code, String msg) {
		super("ERROR CODE: " + code + " - " + msg);
	}
	
	public APIException(String msg) {
		super(msg);
	}
	
}