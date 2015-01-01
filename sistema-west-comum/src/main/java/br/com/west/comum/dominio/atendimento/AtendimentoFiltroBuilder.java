package br.com.west.comum.dominio.atendimento;

import java.util.Date;

import br.com.west.infraestrutura.Builder;
import br.com.west.infraestrutura.Periodo;

public class AtendimentoFiltroBuilder implements Builder<AtendimentoFiltro> {

	private static final long serialVersionUID = -8957354435712411779L;

	private final AtendimentoFiltro filtro;

	private AtendimentoFiltroBuilder() {
		super();

		this.filtro = new AtendimentoFiltro();
	}

	public AtendimentoFiltroBuilder dataEntrada(final Date inicio, final Date fim) {

		filtro.setDataEntrada(new Periodo(inicio, fim));
		filtro.getDataEntrada().extremos();

		return this;
	}

	@Override
	public AtendimentoFiltro build() {
		return filtro;
	}

	public static AtendimentoFiltroBuilder filtro() {
		return new AtendimentoFiltroBuilder();
	}

}
