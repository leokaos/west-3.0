package br.com.west.comum.dominio.parametro;

import static br.com.west.comum.aplicacao.ComumMesssages.PARAMETRO_VAZIO;
import static br.com.west.comum.dominio.parametro.ParametroFiltroBuilder.parametro;
import static br.com.west.util.ValidatorUtil.assertVazioDominio;

import javax.inject.Inject;

import br.com.west.comum.aplicacao.annotation.ParametroServiceInject;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.AbstractService;

@ParametroServiceInject
public class ParametroService extends AbstractService<ParametroBasico<Object>, ParametroFiltro, String, ParametroRepository> {

	private static final long serialVersionUID = 317793094736466347L;

	@Inject
	public ParametroService(final ParametroRepository parametroRepository) {
		super(parametroRepository);
	}

	@SuppressWarnings("rawtypes")
	public ParametroBasico buscarParametroPorNome(final String nome) throws WestException {
		assertVazioDominio(nome, PARAMETRO_VAZIO);

		final ParametroFiltro filtro = parametro().nomeParametro(nome).build();

		return repositorio.buscarUnico(filtro);
	}

}
