package br.com.west.comum.dominio.perfil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.west.infraestrutura.AbstractEntity;

@Entity
@Table(name = "tab_perfil")
public class Perfil extends AbstractEntity<Perfil, Long> {

	private static final long serialVersionUID = -4177678132676387518L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "pagina_dashboard")
	private String paginaDashboard;

	public Perfil() {
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getPaginaDashboard() {
		return this.paginaDashboard;
	}

	public void setPaginaDashboard(final String paginaDashboard) {
		this.paginaDashboard = paginaDashboard;
	}

	@Override
	protected EqualsBuilder getEqualsBuilder(final Perfil other) {
		return new EqualsBuilder().append(nome, other.getNome());
	}

	@Override
	protected HashCodeBuilder getHashCodeBuilder() {
		return new HashCodeBuilder().append(nome);
	}

}