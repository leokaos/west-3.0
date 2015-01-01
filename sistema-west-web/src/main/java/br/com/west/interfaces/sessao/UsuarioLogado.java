package br.com.west.interfaces.sessao;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.west.comum.dominio.perfil.Perfil;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.infraestrutura.ValueObject;

public class UsuarioLogado extends ValueObject<UsuarioLogado> {

	private static final long serialVersionUID = -4099052371608999713L;

	private final Usuario usuario;

	public UsuarioLogado(final Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Perfil getPerfilPrincipal() {
		return usuario.getPerfis().iterator().next();
	}

	@Override
	protected EqualsBuilder getEqualsBuilder(final UsuarioLogado other) {
		return new EqualsBuilder().append(usuario, other.getUsuario());
	}

	@Override
	protected HashCodeBuilder getHashCodeBuilder() {
		return new HashCodeBuilder().append(usuario);
	}

}
