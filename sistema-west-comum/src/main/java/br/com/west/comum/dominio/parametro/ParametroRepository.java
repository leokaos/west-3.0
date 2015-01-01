package br.com.west.comum.dominio.parametro;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.west.comum.aplicacao.annotation.ComumPU;
import br.com.west.infraestrutura.AbstractRepository;

public class ParametroRepository extends AbstractRepository<ParametroBasico<Object>, ParametroFiltro, String> {

	private static final long serialVersionUID = 5484574859701985627L;

	@Inject
	public ParametroRepository(@ComumPU final EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	protected ParametroFiltro getFiltroVazio() {
		return ParametroFiltroBuilder.parametro().build();
	}
}
