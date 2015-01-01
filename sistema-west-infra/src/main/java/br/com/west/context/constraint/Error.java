package br.com.west.context.constraint;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Error implements Comparable<Error> {

	private final String attribute;
	private final String message;
	private final Object[] objects;

	public Error(final String attribute, final String message, final Object... objects) {
		super();
		this.attribute = attribute;
		this.message = message;
		this.objects = objects;
	}

	public String getAttribute() {
		return attribute;
	}

	public String getMessage() {
		return message;
	}

	public Object[] getObjects() {
		return objects;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(attribute).append(message).append(objects).toHashCode();
	}

	@Override
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

		final Error other = (Error) obj;

		final EqualsBuilder equalsBuilder = new EqualsBuilder();

		equalsBuilder.append(attribute, other.attribute);
		equalsBuilder.append(message, other.message);
		equalsBuilder.append(objects, other.objects);

		return equalsBuilder.isEquals();
	}

	@Override
	public int compareTo(final Error o) {
		return new CompareToBuilder().append(attribute, o.getAttribute()).append(message, o.getMessage()).append(objects, o.getObjects()).toComparison();
	}

}
