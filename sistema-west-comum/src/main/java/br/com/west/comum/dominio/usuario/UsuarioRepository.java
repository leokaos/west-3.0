package br.com.west.comum.dominio.usuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.west.comum.aplicacao.annotation.ComumPU;
import br.com.west.infraestrutura.AbstractRepository;

public class UsuarioRepository extends AbstractRepository<Usuario, UsuarioFiltro, Long> {

	private static final long serialVersionUID = -2774613685742192764L;

	@Inject
	public UsuarioRepository(@ComumPU final EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	protected UsuarioFiltro getFiltroVazio() {
		return UsuarioFiltroBuilder.usuarioFiltro().build();
	}

}
