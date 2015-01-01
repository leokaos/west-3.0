package br.com.west.context.constraint;

class LessThan implements Constraint {

	private static final long serialVersionUID = 7869140555678797539L;

	private Number number;
	private double value;

	public LessThan(Number number, double value) {
		super();
		this.number = number;
		this.value = value;
	}

	@Override
	public boolean isValid() {
		return number.doubleValue() < value;
	}

}
