package banksys.persistence.exception;

public class AbstractAccountEmptyException extends Exception {

	private static final long serialVersionUID = 1L;

	public AbstractAccountEmptyException(String message) {
		super(message);
	}
}
