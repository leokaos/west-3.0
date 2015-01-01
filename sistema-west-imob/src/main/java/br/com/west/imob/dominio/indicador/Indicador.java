package br.com.west.imob.dominio.indicador;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.west.infraestrutura.ValueObject;

public class Indicador extends ValueObject<Indicador> {

	private static final long serialVersionUID = 2746065602316862668L;

	private final String descricao;
	private final BigDecimal value;
	private final TipoIndicador tipo;

	public Indicador(final String descricao, final BigDecimal value, final TipoIndicador tipo) {
		super();
		this.descricao = descricao;
		this.value = value;
		this.tipo = tipo;
	}

	public TipoIndicador getTipo() {
		return tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValue() {
		return value;
	}

	@Override
	protected EqualsBuilder getEqualsBuilder(final Indicador other) {
		return new EqualsBuilder().append(descricao, other.getDescricao()).append(value, other.getValue()).append(tipo, other.tipo);
	}

	@Override
	protected HashCodeBuilder getHashCodeBuilder() {
		return new HashCodeBuilder().append(descricao).append(value).append(tipo);
	}

}
