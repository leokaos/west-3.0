package br.com.west.comum.aplicacao.recado;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.west.comum.aplicacao.annotation.RecadoServiceInject;
import br.com.west.comum.dominio.recado.Recado;
import br.com.west.comum.dominio.recado.RecadoFiltro;
import br.com.west.comum.dominio.recado.RecadoRepository;
import br.com.west.comum.dominio.recado.RecadoService;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.AbstractSimpleFacade;

@Stateless
public class RecadoFacadeImpl extends AbstractSimpleFacade<Recado, RecadoFiltro, Long, RecadoService, RecadoRepository> implements RecadoFacade {

	private static final long serialVersionUID = 2766469283333717445L;

	@Inject
	@RecadoServiceInject
	private RecadoService recadoService;

	@Override
	public List<Recado> buscarRecadosPorUsuario(final Usuario usuario) throws WestException {
		return recadoService.buscarRecadosPorUsuario(usuario);
	}

	@Override
	protected RecadoService getService() {
		return recadoService;
	}

}
