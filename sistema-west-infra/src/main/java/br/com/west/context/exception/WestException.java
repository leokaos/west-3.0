package br.com.west.context.exception;

public abstract class WestException extends Exception {

	private static final long serialVersionUID = 8533752457699739347L;

	public WestException() {
		super();
	}

	public WestException(String message) {
		super(message);
	}

	public WestException(String message, Throwable cause) {
		super(message, cause);
	}

	public WestException(Throwable cause) {
		super(cause);
	}

}
