package br.com.west.comum.dominio.recado;

import static br.com.west.comum.aplicacao.ComumMesssages.RECADO_USUARIO_INVALIDO;
import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.easymock.Capture;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.DominioException;
import br.com.west.context.exception.InfraestruturaException;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.AbstractTest;

public class RecadoServiceTest extends AbstractTest<RecadoService> {

	private static final String NOME_USUARIO = "NOME";

	private static final String MSG_ERRO = "MSG_ERRO";

	private static RecadoRepository mockRecadoRepository;

	@Override
	protected RecadoService createObjetoParaTestar() {
		return new RecadoService(mockRecadoRepository);
	}

	@BeforeClass
	public static void setUpClass() {
		mockRecadoRepository = createStrictMock(RecadoRepository.class);

		addMock(mockRecadoRepository);
	}

	private Usuario createUsuario(final boolean duplicaRecado) {
		final Usuario usuario = new Usuario();
		usuario.setNome(NOME_USUARIO);
		usuario.setDuplicaRecado(duplicaRecado);
		return usuario;
	}

	private Recado createRecado() {
		final Recado recado = new Recado();

		final boolean duplicaRecado = true;
		final Usuario usuario = createUsuario(duplicaRecado);

		recado.setUsuario(usuario);
		recado.setDescricao("Teste");

		return recado;
	}

	private List<Recado> createListaRecado() {
		final List<Recado> lista = new ArrayList<Recado>();

		lista.add(createRecado());

		return lista;
	}

	@Test
	public void listarCorretoTest() throws WestException {
		final RecadoService service = createObjetoParaTestar();

		final List<Recado> listaEsperada = createListaRecado();

		expect(mockRecadoRepository.listar()).andReturn(listaEsperada);

		replayAll();

		final List<Recado> lista = service.listar();

		verifyAll();

		assertEquals(lista, listaEsperada);

	}

	@Test
	public void buscarRecadoPorUsuarioComUsuarioNuloTest() {
		final RecadoService recadoService = createObjetoParaTestar();

		try {
			recadoService.buscarRecadosPorUsuario(null);
			fail();
		} catch (final WestException ex) {
			validarException(ex, RECADO_USUARIO_INVALIDO, DominioException.class);
		}
	}

	@Test
	public void buscarRecadoPorUsuarioErroRepositorioTest() throws WestException {
		final RecadoService recadoService = createObjetoParaTestar();

		final Usuario usuario = createUsuario(false);

		final Capture<RecadoFiltro> capture = new Capture<RecadoFiltro>();
		expect(mockRecadoRepository.buscarPorFiltro(capture(capture))).andThrow(new InfraestruturaException(MSG_ERRO));

		replayAll();

		try {
			recadoService.buscarRecadosPorUsuario(usuario);
			fail();
		} catch (final WestException ex) {
			validarException(ex, MSG_ERRO, InfraestruturaException.class);
		}

		verifyAll();

		final RecadoFiltro filtro = capture.getValue();

		assertEquals(filtro.getNomeUsuario(), usuario.getNome());
	}

	@Test
	public void buscarRecadoPorUsuarioCorretoTest() throws WestException {
		final RecadoService recadoService = createObjetoParaTestar();

		final Usuario usuario = createUsuario(false);
		final List<Recado> listaEsperada = createListaRecado();

		final Capture<RecadoFiltro> capture = new Capture<RecadoFiltro>();
		expect(mockRecadoRepository.buscarPorFiltro(capture(capture))).andReturn(listaEsperada);

		replayAll();

		final List<Recado> listaRecuperada = recadoService.buscarRecadosPorUsuario(usuario);

		verifyAll();

		assertEquals(listaEsperada, listaRecuperada);
	}
}
