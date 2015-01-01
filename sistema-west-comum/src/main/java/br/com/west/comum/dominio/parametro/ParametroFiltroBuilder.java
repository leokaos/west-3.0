package br.com.west.comum.dominio.parametro;

import br.com.west.infraestrutura.Builder;

public class ParametroFiltroBuilder implements Builder<ParametroFiltro> {

	private static final long serialVersionUID = 41482029841385909L;

	private String nomeParametro;

	private ParametroFiltroBuilder() {
		super();
	}

	public static ParametroFiltroBuilder parametro() {
		return new ParametroFiltroBuilder();
	}

	public ParametroFiltroBuilder nomeParametro(final String nomeParametro) {
		this.nomeParametro = nomeParametro;

		return this;
	}

	@Override
	public ParametroFiltro build() {
		return new ParametroFiltro(nomeParametro);
	}

}
