package br.com.west.context.constraint;

import static br.com.west.util.ValidatorUtil.isEmpty;

class NullOrEmpty implements Constraint {

	private static final long serialVersionUID = 6499480363398812615L;

	private final String str;

	public NullOrEmpty(String str) {
		this.str = str;
	}

	@Override
	public boolean isValid() {
		return isEmpty(str);
	}

}
