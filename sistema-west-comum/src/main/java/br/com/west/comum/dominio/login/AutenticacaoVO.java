package br.com.west.comum.dominio.login;

import static br.com.west.context.constraint.ConstraintFactory.notNullOrEmpty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.west.context.exception.ValidationException;
import br.com.west.context.validationcontext.ValidationContext;
import br.com.west.infraestrutura.ValueObject;

public class AutenticacaoVO extends ValueObject<AutenticacaoVO> {

	private static final long serialVersionUID = 5517918382598009231L;

	private static final String ATRIBUTO_SENHA = "senha";
	private static final String ATRIBUTO_USUARIO = "usuario";

	private final String usuario;
	private final String senha;

	public AutenticacaoVO(final String usuario, final String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	@Override
	protected EqualsBuilder getEqualsBuilder(final AutenticacaoVO other) {
		return new EqualsBuilder().append(usuario, other.getUsuario()).append(senha, other.getSenha());
	}

	@Override
	protected HashCodeBuilder getHashCodeBuilder() {
		return new HashCodeBuilder().append(usuario).append(senha);
	}

	@Override
	public void validate(final ValidationContext context) throws ValidationException {

		context.add(notNullOrEmpty(usuario), "autenticacao.usuario.vazio", ATRIBUTO_USUARIO);

		context.add(notNullOrEmpty(senha), "autenticacao.senha.vazio", ATRIBUTO_SENHA);
	}
}
