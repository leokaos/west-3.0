package br.com.west.comum.dominio.atendimento;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.west.infraestrutura.AbstractEntity;

@Entity
@Table(name = "tab_atendimento")
public class Atendimento extends AbstractEntity<Atendimento, Long> {

	private static final long serialVersionUID = 3299800049309603496L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "data_entrada")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEntrada;

	public Atendimento() {
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

	@Override
	protected EqualsBuilder getEqualsBuilder(final Atendimento other) {
		return new EqualsBuilder().append(id, other.getId());
	}

	@Override
	protected HashCodeBuilder getHashCodeBuilder() {
		return new HashCodeBuilder().append(id);
	}

}