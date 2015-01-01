package br.com.west.context.exception;

import java.util.Set;

import br.com.west.context.constraint.Error;

public class ValidationException extends WestException {

	private static final long serialVersionUID = -4376506518199565888L;

	private final Set<Error> errors;

	public ValidationException(Set<Error> errors) {
		this.errors = errors;
	}

	public Set<Error> getErrors() {
		return errors;
	}

}
