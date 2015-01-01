package br.com.west.context.constraint;

import static br.com.west.util.ValidatorUtil.isNull;

@SuppressWarnings("rawtypes")
public abstract class ComparableConstraint implements Constraint {

	private static final long serialVersionUID = -1563972575301723200L;

	protected final Comparable obj1;
	protected final Comparable obj2;

	public ComparableConstraint(final Comparable obj1, final Comparable obj2) {
		super();

		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	@Override
	public boolean isValid() {

		if (isNull(obj1) || isNull(obj2)) {
			return false;
		}

		return doValid();
	}

	protected abstract boolean doValid();

}