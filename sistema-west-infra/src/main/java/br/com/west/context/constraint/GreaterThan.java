package br.com.west.context.constraint;

class GreaterThan implements Constraint {

	private static final long serialVersionUID = -2932644535882580461L;

	private double value;
	private Number number;

	public GreaterThan(Number number, double value) {
		super();
		this.number = number;
		this.value = value;
	}

	@Override
	public boolean isValid() {
		return number.doubleValue() > this.value;
	}
}
