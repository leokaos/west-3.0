package br.com.west.comum.aplicacao.atendimento;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.west.comum.aplicacao.annotation.AtendimentoServiceInject;
import br.com.west.comum.dominio.atendimento.Atendimento;
import br.com.west.comum.dominio.atendimento.AtendimentoFiltro;
import br.com.west.comum.dominio.atendimento.AtendimentoRepository;
import br.com.west.comum.dominio.atendimento.AtendimentoService;
import br.com.west.infraestrutura.AbstractSimpleFacade;

@Stateless
public class AtendimentoFacadeImpl extends AbstractSimpleFacade<Atendimento, AtendimentoFiltro, Long, AtendimentoService, AtendimentoRepository> implements
		AtendimentoFacade {

	private static final long serialVersionUID = 4019501465582849609L;

	@Inject
	@AtendimentoServiceInject
	private AtendimentoService AtendimentoService;

	@Override
	protected AtendimentoService getService() {
		return AtendimentoService;
	}

}
