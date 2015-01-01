package br.com.west.comum.dominio.parametro;

import static br.com.startup.query.conditions.ConditionFactory.equal;
import static br.com.west.util.ValidatorUtil.isNotEmpty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.startup.query.QueryBuilder;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.AbstractFiltro;

public class ParametroFiltro extends AbstractFiltro<ParametroFiltro> {

	private static final long serialVersionUID = 7364699211507877581L;

	private final String nomeParametro;

	public ParametroFiltro(final String nomeParametro) {
		super();
		this.nomeParametro = nomeParametro;
	}

	public String getNomeParametro() {
		return nomeParametro;
	}

	public boolean hasNomeParametro() {
		return isNotEmpty(nomeParametro);
	}

	@Override
	protected EqualsBuilder getEqualsBuilder(final ParametroFiltro other) {
		return new EqualsBuilder().append(nomeParametro, other.nomeParametro);
	}

	@Override
	protected HashCodeBuilder getHashCodeBuilder() {
		return new HashCodeBuilder().append(nomeParametro);
	}

	@Override
	public void doQuery(final QueryBuilder builder) throws WestException {

		if (hasNomeParametro()) {
			builder.where(equal("nome", getNomeParametro()));
		}
	}

	@Override
	public Class<?> getEntityClass() {
		return ParametroBasico.class;
	}

}
