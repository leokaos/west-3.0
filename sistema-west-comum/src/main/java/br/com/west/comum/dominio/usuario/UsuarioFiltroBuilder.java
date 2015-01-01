package br.com.west.comum.dominio.usuario;

import br.com.west.infraestrutura.Builder;

public class UsuarioFiltroBuilder implements Builder<UsuarioFiltro> {

	private static final long serialVersionUID = -8957354435712411779L;

	private String usuario;
	private String senha;

	private UsuarioFiltroBuilder() {
		super();
	}

	public UsuarioFiltroBuilder nomeUsuario(final String usuario) {
		this.usuario = usuario;
		return this;
	}

	public UsuarioFiltroBuilder senha(final String senha) {
		this.senha = senha;
		return this;
	}

	@Override
	public UsuarioFiltro build() {
		final UsuarioFiltro usuarioFiltro = new UsuarioFiltro();

		usuarioFiltro.setNomeUsuario(usuario);
		usuarioFiltro.setSenha(senha);

		return usuarioFiltro;
	}

	public static UsuarioFiltroBuilder usuarioFiltro() {
		return new UsuarioFiltroBuilder();
	}

}
