package br.com.west.context.constraint;

import static br.com.west.util.ValidatorUtil.not;

class Not implements Constraint {

	private static final long serialVersionUID = -908556124515590558L;

	private Constraint innerConstraint;

	public Not(Constraint innerConstraint) {
		super();
		this.innerConstraint = innerConstraint;
	}

	@Override
	public boolean isValid() {
		return not(innerConstraint.isValid());
	}

}
