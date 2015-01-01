package br.com.west.comum.dominio.usuario;

import br.com.west.infraestrutura.Builder;

public class UsuarioBuilder implements Builder<Usuario> {

	private static final long serialVersionUID = -8376435341043697394L;

	private String nome;
	private Long id;

	private UsuarioBuilder() {
		super();
	}

	public UsuarioBuilder nome(final String nome) {
		this.nome = nome;

		return this;
	}

	public static UsuarioBuilder usuario() {
		return new UsuarioBuilder();
	}

	public UsuarioBuilder id(final Long id) {
		this.id = id;

		return this;
	}

	@Override
	public Usuario build() {
		final Usuario usuario = new Usuario();

		usuario.setNome(nome);
		usuario.setId(id);

		return usuario;
	}
}
