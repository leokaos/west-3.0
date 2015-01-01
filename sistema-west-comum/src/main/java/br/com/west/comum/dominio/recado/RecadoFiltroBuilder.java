package br.com.west.comum.dominio.recado;

import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.infraestrutura.Builder;

public class RecadoFiltroBuilder implements Builder<RecadoFiltro> {

	private static final long serialVersionUID = 6870703074267779659L;

	private String nomeUsuario;

	private RecadoFiltroBuilder() {
		super();
	}

	@Override
	public RecadoFiltro build() {
		final RecadoFiltro recadoFiltro = new RecadoFiltro();

		recadoFiltro.setNomeUsuario(nomeUsuario);

		return recadoFiltro;
	}

	public static RecadoFiltroBuilder recado() {
		return new RecadoFiltroBuilder();
	}

	public RecadoFiltroBuilder usuario(final Usuario usuario) {
		this.nomeUsuario = usuario.getNome();

		return this;
	}

}
