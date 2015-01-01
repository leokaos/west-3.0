package br.com.west.comum.dominio.atendimento;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.west.comum.aplicacao.annotation.ComumPU;
import br.com.west.infraestrutura.AbstractRepository;

public class AtendimentoRepository extends AbstractRepository<Atendimento, AtendimentoFiltro, Long> {

	private static final long serialVersionUID = -2774613685742192764L;

	@Inject
	public AtendimentoRepository(@ComumPU final EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	protected AtendimentoFiltro getFiltroVazio() {
		return AtendimentoFiltroBuilder.filtro().build();
	}

}
