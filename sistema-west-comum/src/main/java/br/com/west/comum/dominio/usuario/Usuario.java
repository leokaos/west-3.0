package br.com.west.comum.dominio.usuario;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.west.comum.dominio.perfil.Perfil;
import br.com.west.infraestrutura.AbstractEntity;

@Entity
@Table(name = "tab_usuario")
public class Usuario extends AbstractEntity<Usuario, Long> {

	private static final long serialVersionUID = 3299800049309603496L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "senha", nullable = false, length = 40)
	private String senha;

	@Column(name = "nome_completo", nullable = true, length = 255)
	private String nomeCompleto;

	@Column(name = "bloqueado", nullable = false)
	private boolean bloqueado;

	@Column(name = "cor", nullable = true, length = 11)
	private String cor;

	@Column(name = "email", nullable = true, length = 50)
	private String email;

	@Column(name = "fake", nullable = true)
	private boolean fake;

	@Column(name = "duplica_recado")
	private boolean duplicaRecado;

	@Column(name = "telefone")
	private String telefone;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tab_perfil_usuario", joinColumns = { @JoinColumn(name = "usuario_id") }, inverseJoinColumns = { @JoinColumn(name = "perfil_id") })
	private Set<Perfil> perfis;

	public Usuario() {
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
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(final String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(final boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(final String cor) {
		this.cor = cor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public boolean isFake() {
		return fake;
	}

	public void setFake(final boolean fake) {
		this.fake = fake;
	}

	public boolean isDuplicaRecado() {
		return duplicaRecado;
	}

	public void setDuplicaRecado(final boolean duplicaRecado) {
		this.duplicaRecado = duplicaRecado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(final Set<Perfil> perfis) {
		this.perfis = perfis;
	}

	@Override
	protected EqualsBuilder getEqualsBuilder(final Usuario other) {
		return new EqualsBuilder().append(getId(), other.getId());
	}

	@Override
	protected HashCodeBuilder getHashCodeBuilder() {
		return new HashCodeBuilder().append(getId());
	}

}