package br.com.west.comum.dominio.atendimento;

import static br.com.startup.query.conditions.ConditionFactory.between;
import static br.com.west.util.ValidatorUtil.isNotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.startup.query.QueryBuilder;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.AbstractFiltro;
import br.com.west.infraestrutura.Periodo;

public class AtendimentoFiltro extends AbstractFiltro<AtendimentoFiltro> {

	private static final long serialVersionUID = 8290906988078599319L;

	private Periodo dataEntrada;

	public AtendimentoFiltro() {
		super();
	}

	public Periodo getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(final Periodo dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public boolean hasDataEntrada() {
		return isNotNull(dataEntrada);
	}

	@Override
	public void doQuery(final QueryBuilder builder) throws WestException {

		if (hasDataEntrada()) {
			builder.where(between("dataEntrada", dataEntrada.getDataInicial(), dataEntrada.getDataFinal()));
		}
	}

	@Override
	protected EqualsBuilder getEqualsBuilder(final AtendimentoFiltro other) {
		return new EqualsBuilder().append(dataEntrada, other.dataEntrada);
	}

	@Override
	protected HashCodeBuilder getHashCodeBuilder() {
		return new HashCodeBuilder().append(dataEntrada);
	}

	@Override
	public Class<?> getEntityClass() {
		return Atendimento.class;
	}

}
