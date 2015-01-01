package br.com.west.context.validationcontext;

import java.io.Serializable;

import br.com.west.context.constraint.Constraint;
import br.com.west.context.exception.ValidationException;

public interface ValidationContext extends Serializable {

	void add(Constraint constraint, String message, String attribute, Object... objects);

	void validate() throws ValidationException;

	boolean hasErrors();
}
