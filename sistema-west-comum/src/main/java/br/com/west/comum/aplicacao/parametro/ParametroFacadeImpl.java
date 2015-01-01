package br.com.west.comum.aplicacao.parametro;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.west.comum.aplicacao.annotation.ParametroServiceInject;
import br.com.west.comum.dominio.parametro.ParametroBasico;
import br.com.west.comum.dominio.parametro.ParametroFiltro;
import br.com.west.comum.dominio.parametro.ParametroRepository;
import br.com.west.comum.dominio.parametro.ParametroService;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.AbstractSimpleFacade;

@Stateless
public class ParametroFacadeImpl extends AbstractSimpleFacade<ParametroBasico<Object>, ParametroFiltro, String, ParametroService, ParametroRepository>
		implements ParametroFacade {

	private static final long serialVersionUID = 1243560033349507264L;

	@Inject
	@ParametroServiceInject
	private ParametroService service;

	@Override
	@SuppressWarnings("rawtypes")
	public ParametroBasico buscarParametroPorNome(final String nome) throws WestException {
		return service.buscarParametroPorNome(nome);
	}

	@Override
	protected ParametroService getService() {
		return service;
	}

}
