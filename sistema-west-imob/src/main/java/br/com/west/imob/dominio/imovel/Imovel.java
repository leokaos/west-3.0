package br.com.west.imob.dominio.imovel;

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
@Table(name = "tab_imovel")
public class Imovel extends AbstractEntity<Imovel, Long> {

	private static final long serialVersionUID = -5151671756353904979L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_angariacao")
	private Date dataAngariacao;

	public Imovel() {
		super();
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(final Long id) {
		this.id = id;
	}

	public Date getDataAngariacao() {
		return this.dataAngariacao;
	}

	public void setDataAngariacao(final Date dataAngariacao) {
		this.dataAngariacao = dataAngariacao;
	}

	@Override
	protected EqualsBuilder getEqualsBuilder(final Imovel other) {
		return new EqualsBuilder().append(getId(), other.getId());
	}

	@Override
	protected HashCodeBuilder getHashCodeBuilder() {
		return new HashCodeBuilder().append(getId());
	}

}