package br.com.west.context.exception;

public class InfraestruturaException extends WestException {

	private static final long serialVersionUID = -5818490456153385598L;

	public InfraestruturaException() {
		super();
	}

	public InfraestruturaException(final String message) {
		super(message);
	}

	public InfraestruturaException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public InfraestruturaException(final Throwable cause) {
		super(cause);
	}

}
