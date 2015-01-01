package br.com.west.comum.dominio.atendimento;

import javax.inject.Inject;

import br.com.west.comum.aplicacao.annotation.AtendimentoServiceInject;
import br.com.west.infraestrutura.AbstractService;

@AtendimentoServiceInject
public class AtendimentoService extends AbstractService<Atendimento, AtendimentoFiltro, Long, AtendimentoRepository> {

	private static final long serialVersionUID = -1813224418737658841L;

	@Inject
	public AtendimentoService(final AtendimentoRepository AtendimentoRepository) {
		super(AtendimentoRepository);
	}

}
