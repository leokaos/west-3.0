package br.com.west.imob.dominio.imovel;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.west.comum.aplicacao.annotation.ImobPU;
import br.com.west.infraestrutura.AbstractRepository;

public class ImovelRepository extends AbstractRepository<Imovel, ImovelFiltro, Long> {

	private static final long serialVersionUID = -2317655305039782759L;

	@Inject
	public ImovelRepository(@ImobPU final EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	protected ImovelFiltro getFiltroVazio() {
		return ImovelFiltroBuilder.imovelFiltro().build();
	}
}
