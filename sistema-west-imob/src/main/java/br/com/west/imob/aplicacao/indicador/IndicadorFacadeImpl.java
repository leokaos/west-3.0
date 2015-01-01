package br.com.west.imob.aplicacao.indicador;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.west.comum.aplicacao.annotation.IndicadorServiceInject;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.WestException;
import br.com.west.imob.dominio.indicador.Indicador;
import br.com.west.imob.dominio.indicador.IndicadorService;

@Stateless
public class IndicadorFacadeImpl implements IndicadorFacade {

	private static final long serialVersionUID = -867548802259688496L;

	@Inject
	@IndicadorServiceInject
	private IndicadorService service;

	@Override
	public List<Indicador> buscarIndicadoresPorUsuario(final Usuario usuario) throws WestException {
		return service.buscarIndicadoresPorUsuario(usuario);
	}

}
