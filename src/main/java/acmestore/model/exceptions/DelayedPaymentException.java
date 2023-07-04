package acmestore.model.exceptions;

public class DelayedPaymentException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DelayedPaymentException() {
	}
	
	public DelayedPaymentException(String msg) {
		super(msg);
	}
	
	public DelayedPaymentException(String msg, Throwable cause) {
		super(msg, cause);
	}
}