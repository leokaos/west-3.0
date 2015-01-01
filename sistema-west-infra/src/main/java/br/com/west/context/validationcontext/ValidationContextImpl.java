package br.com.west.context.validationcontext;

import static br.com.west.util.ValidatorUtil.not;

import java.util.Set;
import java.util.TreeSet;

import br.com.west.context.constraint.Constraint;
import br.com.west.context.constraint.Error;
import br.com.west.context.exception.ValidationException;

public class ValidationContextImpl implements ValidationContext {

	private static final long serialVersionUID = -7006025383581793395L;

	private Set<Error> erros;

	private ValidationContextImpl() {
	super();

	this.erros = new TreeSet<>();
    }

	public static ValidationContext getInstance() {
		return new ValidationContextImpl();
	}

	@Override
	public void add(Constraint constraint, String message, String attribute, Object... objects) {
		if (not(constraint.isValid())) {
			erros.add(new Error(attribute, message, objects));
		}
	}

	@Override
	public void validate() throws ValidationException {
		if (hasErrors()) {
			throw new ValidationException(erros);
		}
	}

	@Override
	public boolean hasErrors() {
		return !erros.isEmpty();
	}

}
