package br.com.west.comum.dominio.usuario;

import static br.com.west.comum.aplicacao.ComumMesssages.USUARIO_INVALIDO;
import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.easymock.Capture;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.west.context.exception.DominioException;
import br.com.west.context.exception.InfraestruturaException;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.AbstractTest;

public class UsuarioServiceTest extends AbstractTest<UsuarioService> {

	private static UsuarioRepository mockUsuarioRepositorio;

	@BeforeClass
	public static void setUp() {

		mockUsuarioRepositorio = createStrictMock(UsuarioRepository.class);

		addMock(mockUsuarioRepositorio);
	}

	@Override
	protected UsuarioService createObjetoParaTestar() {
		return new UsuarioService(mockUsuarioRepositorio);
	}

	@Test
	public void buscarUsuarioPorNomeSenhaUsuarioVazioTest() throws Exception {
		final UsuarioService service = createObjetoParaTestar();

		try {
			service.buscarUsuarioPorNomeSenha(null, null);
			fail();
		} catch (final WestException ex) {
			validarException(ex, USUARIO_INVALIDO, DominioException.class);
		}
	}

	@Test
	public void buscarUsuarioPorNomeSenhaErroRepositorioTest() throws Exception {
		final UsuarioService service = createObjetoParaTestar();

		final Capture<UsuarioFiltro> captureFiltro = new Capture<UsuarioFiltro>();
		final String nomeUsuario = "usuario";
		final String senha = "senha";

		expect(mockUsuarioRepositorio.buscarUnico(capture(captureFiltro))).andThrow(new InfraestruturaException());

		replayAll();

		try {
			service.buscarUsuarioPorNomeSenha(nomeUsuario, senha);
			fail();
		} catch (final WestException ex) {
			validarException(ex, null, InfraestruturaException.class);
		}

		verifyAll();

		final UsuarioFiltro filtro = captureFiltro.getValue();

		assertEquals(filtro.getNomeUsuario(), nomeUsuario);
		assertEquals(filtro.getSenha(), senha);
	}

	@Test
	public void buscarUsuarioPorNomeSenhaCorretoTest() throws Exception {
		final UsuarioService service = createObjetoParaTestar();

		final Capture<UsuarioFiltro> captureFiltro = new Capture<UsuarioFiltro>();
		final String nomeUsuario = "usuario";
		final String senha = "senha";

		expect(mockUsuarioRepositorio.buscarUnico(capture(captureFiltro))).andReturn(new Usuario());

		replayAll();

		final Usuario usuario = service.buscarUsuarioPorNomeSenha(nomeUsuario, senha);

		verifyAll();

		final UsuarioFiltro filtro = captureFiltro.getValue();

		assertEquals(filtro.getNomeUsuario(), nomeUsuario);
		assertEquals(filtro.getSenha(), senha);
		assertEquals(new Usuario(), usuario);
	}
}
