package br.com.west.comum.dominio.recado;

import static br.com.startup.query.conditions.ConditionFactory.equal;
import static br.com.west.util.ValidatorUtil.isNotEmpty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.startup.query.QueryBuilder;
import br.com.startup.query.order.Order;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.AbstractFiltro;

public class RecadoFiltro extends AbstractFiltro<RecadoFiltro> {

	private static final long serialVersionUID = 947255235951123565L;

	private String nomeUsuario;

	public RecadoFiltro() {
		super();
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(final String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	@Override
	protected EqualsBuilder getEqualsBuilder(final RecadoFiltro other) {
		return new EqualsBuilder().append(nomeUsuario, other.nomeUsuario);
	}

	@Override
	protected HashCodeBuilder getHashCodeBuilder() {
		return new HashCodeBuilder().append(nomeUsuario);
	}

	public boolean hasNomeUsuario() {
		return isNotEmpty(nomeUsuario);
	}

	@Override
	public void doQuery(final QueryBuilder builder) throws WestException {

		if (hasNomeUsuario()) {
			builder.where(equal("usuario.nome", getNomeUsuario()));
		}

		builder.order(Order.desc("dataEntrada"));
	}

	@Override
	public Class<?> getEntityClass() {
		return Recado.class;
	}

}
