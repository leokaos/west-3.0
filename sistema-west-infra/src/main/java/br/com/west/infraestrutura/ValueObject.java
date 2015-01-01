package br.com.west.infraestrutura;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.west.context.exception.ValidationException;
import br.com.west.context.validationcontext.Validable;
import br.com.west.context.validationcontext.ValidationContext;

public abstract class ValueObject<T> implements Serializable, Validable {

	private static final long serialVersionUID = 6356621838597168962L;

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(final Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		final T other = (T) obj;

		return getEqualsBuilder(other).isEquals();
	}

	@Override
	public int hashCode() {
		return getHashCodeBuilder().toHashCode();
	}

	@Override
	public void validate(final ValidationContext context) throws ValidationException {

	}

	protected abstract EqualsBuilder getEqualsBuilder(T other);

	protected abstract HashCodeBuilder getHashCodeBuilder();

}
