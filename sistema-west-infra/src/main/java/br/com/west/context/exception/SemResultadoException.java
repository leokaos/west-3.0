package br.com.west.context.exception;

import static br.com.west.infraestrutura.InfraestruturaMensagens.NAO_ENCONTRADO;

public class SemResultadoException extends WestException {

	private static final long serialVersionUID = -4152589929610799638L;

	public SemResultadoException() {
		this(NAO_ENCONTRADO);
	}

	public SemResultadoException(String message) {
		super(message);
	}

	public SemResultadoException(String message, Throwable cause) {
		super(message, cause);
	}

	public SemResultadoException(Throwable cause) {
		super(cause);
	}
}
