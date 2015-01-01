package br.com.west.context.exception;

public class DominioException extends WestException {

	private static final long serialVersionUID = -2232515237288382590L;

	public DominioException() {
		super();
	}

	public DominioException(String message) {
		super(message);
	}

	public DominioException(String message, Throwable cause) {
		super(message, cause);
	}

	public DominioException(Throwable cause) {
		super(cause);
	}

}
