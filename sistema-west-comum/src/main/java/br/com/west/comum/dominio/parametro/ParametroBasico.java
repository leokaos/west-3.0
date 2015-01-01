package br.com.west.comum.dominio.parametro;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.west.context.exception.ValidationException;
import br.com.west.context.validationcontext.ValidationContext;
import br.com.west.infraestrutura.AbstractEntity;

@Entity
@Table(name = "tab_parametro")
@DiscriminatorColumn(name = "param_tipo")
@AttributeOverride(name = "param_tipo", column = @Column(name = "param_tipo", nullable = false, insertable = false, updatable = false))
public abstract class ParametroBasico<T> extends AbstractEntity<ParametroBasico<T>, String> {

	private static final long serialVersionUID = -9196216420686755818L;

	@Id
	@Column(name = "param_name")
	private String nome;

	@Column(name = "param_valor")
	private String valor;

	@Column(name = "param_descricao")
	private String descricao;

	@Column(name = "param_tipo", insertable = false, updatable = false)
	@Enumerated(EnumType.STRING)
	private TipoParametro tipoParametro;

	public ParametroBasico() {
		super();
	}

	@Override
	public String getId() {
		return getNome();
	}

	@Override
	public void setId(final String id) {
		setNome(id);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(final String valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public TipoParametro getTipoParametro() {
		return tipoParametro;
	}

	public void setTipoParametro(final TipoParametro tipoParametro) {
		this.tipoParametro = tipoParametro;
	}

	@Override
	protected EqualsBuilder getEqualsBuilder(final ParametroBasico<T> other) {
		return new EqualsBuilder().append(other.getNome(), getNome());
	}

	@Override
	protected HashCodeBuilder getHashCodeBuilder() {
		return new HashCodeBuilder().append(getNome());
	}

	public boolean isDate() {
		return isParametroTipo(TipoParametro.DATE);
	}

	public boolean isString() {
		return isParametroTipo(TipoParametro.STRING);
	}

	public boolean isDouble() {
		return isParametroTipo(TipoParametro.DOUBLE);
	}

	public boolean isInteger() {
		return isParametroTipo(TipoParametro.INTEGER);
	}

	private boolean isParametroTipo(final TipoParametro tipo) {
		return getTipoParametro().equals(tipo);
	}

	@Override
	public void validate(final ValidationContext context) throws ValidationException {
		super.validate(context);
	}

	public abstract T getValorParametro();

	public abstract void setValorParametro(T t);
}
