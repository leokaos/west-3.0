package br.com.west.comum.dominio.recado;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.ValidationException;
import br.com.west.context.validationcontext.ValidationContext;
import br.com.west.infraestrutura.AbstractEntity;

@Entity
@Table(name = "tab_recados")
public class Recado extends AbstractEntity<Recado, Long> {

	private static final long serialVersionUID = 4482875553658176076L;

	@Id
	@Column(name = "id", length = 20, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "data_entrada", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEntrada;

	@Column(name = "data_leitura", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataLeitura;

	@ManyToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;

	public Recado() {
		super();
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(final Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(final Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataLeitura() {
		return dataLeitura;
	}

	public void setDataLeitura(final Date dataLeitura) {
		this.dataLeitura = dataLeitura;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	protected EqualsBuilder getEqualsBuilder(final Recado other) {
		return null;
	}

	@Override
	protected HashCodeBuilder getHashCodeBuilder() {
		return null;
	}

	@Override
	public void validate(final ValidationContext context) throws ValidationException {

	}

}