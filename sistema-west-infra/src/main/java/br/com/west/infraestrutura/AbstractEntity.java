package br.com.west.infraestrutura;

import java.io.Serializable;

import br.com.west.context.exception.ValidationException;
import br.com.west.context.validationcontext.ValidationContext;

public abstract class AbstractEntity<T extends AbstractEntity<T, I>, I extends Serializable> extends ValueObject<T> implements Identifiable<I> {

	private static final long serialVersionUID = 1847530652861450936L;

	@Override
	public void validate(final ValidationContext context) throws ValidationException {

	}

}
