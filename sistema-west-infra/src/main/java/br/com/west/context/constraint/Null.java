package br.com.west.context.constraint;

import static br.com.west.util.ValidatorUtil.isNull;

class Null implements Constraint {

	private static final long serialVersionUID = 1736251054080529822L;

	private final Object obj;

	public Null(Object obj) {
		super();
		this.obj = obj;
	}

	@Override
	public boolean isValid() {
		return isNull(obj);
	}

}
