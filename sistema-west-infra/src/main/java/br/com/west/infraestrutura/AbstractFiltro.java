package br.com.west.infraestrutura;

import br.com.startup.query.QueryBuilder;
import br.com.west.context.exception.ValidationException;
import br.com.west.context.exception.WestException;
import br.com.west.context.validationcontext.ValidationContext;

public abstract class AbstractFiltro<F extends AbstractFiltro<F>> extends ValueObject<F> {

	private static final long serialVersionUID = 4590972096511293965L;

	private int maxResults;
	private int firstResult;

	public AbstractFiltro() {
		super();
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(final int maxResults) {
		this.maxResults = maxResults;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(final int firstResult) {
		this.firstResult = firstResult;
	}

	@Override
	public void validate(final ValidationContext context) throws ValidationException {

	}

	public abstract void doQuery(QueryBuilder builder) throws WestException;

	public abstract Class<?> getEntityClass();

}
