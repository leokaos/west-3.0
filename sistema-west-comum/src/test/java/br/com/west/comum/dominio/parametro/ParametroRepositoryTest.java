package br.com.west.comum.dominio.parametro;

import br.com.west.infraestrutura.AbstractRepositoryTest;

public class ParametroRepositoryTest extends AbstractRepositoryTest<ParametroRepository> {

	@Override
	protected String getFileDataSet() {
		return "Parametros.xml";
	}

	@Override
	protected ParametroRepository createObjetoParaTestar() {
		return new ParametroRepository(entityManager);
	}

	// @Test
	// public void getParametroPorNomeTestCorreto() throws WestException {
	// final ParametroRepository repositorio = getObjeto();
	//
	// final Parametro parametro =
	// repositorio.getParametroPorNome("emailSuper");
	//
	// assertThat(parametro, notNullValue());
	// }
	//
	// @Test
	// public void getParametroPorNomeParametroInexistente() throws
	// WestException {
	// final ParametroRepository repositorio = getObjeto();
	//
	// try {
	// repositorio.getParametroPorNome("parametroInexistente");
	// fail();
	// } catch (final WestException ex) {
	// validarException(ex, ImobMensagens.MENSAGEM_PARAMETRO_INEXISTENTE,
	// InfraestruturaException.class);
	// }
	//
	// }
}
