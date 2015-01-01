package br.com.west.comum.dominio.recado;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.west.comum.aplicacao.annotation.ComumPU;
import br.com.west.infraestrutura.AbstractRepository;

public class RecadoRepository extends AbstractRepository<Recado, RecadoFiltro, Long> {

	private static final long serialVersionUID = 5066069826907990956L;

	@Inject
	public RecadoRepository(@ComumPU final EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	protected RecadoFiltro getFiltroVazio() {
		return RecadoFiltroBuilder.recado().build();
	}

}
