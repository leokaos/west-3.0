package br.com.west.context.constraint;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ComparableLessThan extends ComparableConstraint {

	private static final long serialVersionUID = 8456850551938843734L;

	public ComparableLessThan(final Comparable obj1, final Comparable obj2) {
		super(obj1, obj2);
	}

	@Override
	protected boolean doValid() {
		return obj1.compareTo(obj2) < 0;
	}

}
