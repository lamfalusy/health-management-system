package hu.lamsoft.hms.customer.service.customer.exception;

public class EmailAddressAlreadyUsedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Email address has been already used.";

	public EmailAddressAlreadyUsedException() {
		super(MESSAGE);
	}
	
}
