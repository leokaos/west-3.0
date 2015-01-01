package br.com.west.context.constraint;

public class ConstraintFactory {

	private ConstraintFactory() {
		super();
	}

	public static Constraint nullValue(final Object obj) {
		return new Null(obj);
	}

	public static Constraint notNullValue(final Object obj) {
		return new Not(new Null(obj));
	}

	public static Constraint nullOrEmpty(final String str) {
		return new NullOrEmpty(str);
	}

	public static Constraint notNullOrEmpty(final String str) {
		return new Not(new NullOrEmpty(str));
	}

	public static Constraint greaterThanZero(final Number number) {
		return new GreaterThan(number, 0.0);
	}

	public static Constraint greaterThan(final Number number, final Number value) {
		return new GreaterThan(number, value.doubleValue());
	}

	public static Constraint lessThanZero(final Number number) {
		return new LessThan(number, 0.0);
	}

	public static Constraint lessThan(final Number number, final Number value) {
		return new LessThan(number, value.doubleValue());
	}

	@SuppressWarnings("rawtypes")
	public static Constraint comparableGreaterThan(final Comparable obj1, final Comparable obj2) {
		return new ComparableGreaterThan(obj1, obj2);
	}

	@SuppressWarnings("rawtypes")
	public static Constraint comparableGreaterOrEqual(final Comparable obj1, final Comparable obj2) {
		return new ComparableGreaterOrEqual(obj1, obj2);
	}

	@SuppressWarnings("rawtypes")
	public static Constraint comparableLessThan(final Comparable obj1, final Comparable obj2) {
		return new ComparableLessThan(obj1, obj2);
	}

	@SuppressWarnings("rawtypes")
	public static Constraint comparableLessOrEqual(final Comparable obj1, final Comparable obj2) {
		return new ComparableLessOrEqual(obj1, obj2);
	}

}
