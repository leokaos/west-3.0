package br.com.west.comum.dominio.parametro;

import static br.com.west.comum.aplicacao.ComumMesssages.PARAMETRO_VAZIO;
import static br.com.west.infraestrutura.InfraestruturaMensagens.NAO_ENCONTRADO;
import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.easymock.Capture;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.west.context.exception.DominioException;
import br.com.west.context.exception.SemResultadoException;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.AbstractTest;

public class ParametroServiceTest extends AbstractTest<ParametroService> {

	private static final String PARAMETRO_NOME = "PARAMETRO";
	private static ParametroRepository mockParametroRepository;

	@BeforeClass
	public static void setUp() {
		mockParametroRepository = createStrictMock(ParametroRepository.class);

		addMock(mockParametroRepository);
	}

	@Override
	protected ParametroService createObjetoParaTestar() {
		return new ParametroService(mockParametroRepository);
	}

	@Test
	public void buscarParametroPorNomeNomeParametroVazioTest() throws Exception {
		final ParametroService service = createObjetoParaTestar();

		try {
			service.buscarParametroPorNome("");
			fail();
		} catch (final WestException ex) {
			validarException(ex, PARAMETRO_VAZIO, DominioException.class);
		}
	}

	@Test
	public void buscarParametroPorNomeParametroInexistenteTest() throws Exception {
		final ParametroService service = createObjetoParaTestar();

		final Capture<ParametroFiltro> captureFiltro = new Capture<ParametroFiltro>();
		expect(mockParametroRepository.buscarUnico(capture(captureFiltro))).andThrow(new SemResultadoException(NAO_ENCONTRADO));

		replayAll();

		try {
			service.buscarParametroPorNome(PARAMETRO_NOME);
			fail();
		} catch (final WestException ex) {
			validarException(ex, NAO_ENCONTRADO, SemResultadoException.class);
		}

		verifyAll();

		final ParametroFiltro filtro = captureFiltro.getValue();

		assertEquals(PARAMETRO_NOME, filtro.getNomeParametro());
	}

//	@Test
//	public void buscarParametroPorNomeParametroExistenteTest() throws Exception {
//		final ParametroService service = createObjetoParaTestar();
//
//		final ParametroBasico<String> parametroRetorno = new ParametroString();
//
//		final Capture<ParametroFiltro> captureFiltro = new Capture<ParametroFiltro>();
//		expect(mockParametroRepository.buscarUnico(capture(captureFiltro))).andReturn(parametroRetorno);
//		replayAll();
//
//		try {
//
//			final ParametroBasico<?> parametro = service.buscarParametroPorNome(PARAMETRO_NOME);
//
//			assertEquals(parametro, parametroRetorno);
//
//		} catch (final WestException ex) {
//			fail();
//		}
//
//		verifyAll();
//
//		final ParametroFiltro filtro = captureFiltro.getValue();
//
//		assertEquals(PARAMETRO_NOME, filtro.getNomeParametro());
//	}

}
