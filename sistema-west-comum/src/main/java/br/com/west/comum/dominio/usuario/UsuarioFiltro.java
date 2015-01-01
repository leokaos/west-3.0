package br.com.west.comum.dominio.usuario;

import static br.com.startup.query.conditions.ConditionFactory.equal;
import static br.com.west.util.ValidatorUtil.isNotEmpty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.startup.query.QueryBuilder;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.AbstractFiltro;

public class UsuarioFiltro extends AbstractFiltro<UsuarioFiltro> {

	private static final long serialVersionUID = 8290906988078599319L;

	private String nomeUsuario;
	private String senha;

	public UsuarioFiltro() {
		super();
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(final String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

	public boolean hasNomeUsuario() {
		return isNotEmpty(nomeUsuario);
	}

	public boolean hasSenha() {
		return isNotEmpty(senha);
	}

	@Override
	public void doQuery(final QueryBuilder builder) throws WestException {

		if (hasNomeUsuario() && hasSenha()) {
			builder.where(equal("nome", getNomeUsuario()));
			builder.where(equal("senha", getSenha()));
		}

	}

	@Override
	protected EqualsBuilder getEqualsBuilder(final UsuarioFiltro other) {
		return new EqualsBuilder().append(nomeUsuario, other.nomeUsuario).append(senha, other.senha);
	}

	@Override
	protected HashCodeBuilder getHashCodeBuilder() {
		return new HashCodeBuilder().append(nomeUsuario).append(senha);
	}

	@Override
	public Class<?> getEntityClass() {
		return Usuario.class;
	}

}
