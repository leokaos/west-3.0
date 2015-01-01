package br.com.west.interfaces.login;

import static br.com.west.interfaces.login.LoginController.ENTRAR_SISTEMA;
import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.easymock.Capture;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.west.comum.aplicacao.login.AutenticacaoFacade;
import br.com.west.comum.dominio.login.AutenticacaoVO;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.infraestrutura.AbstractTest;
import br.com.west.interfaces.infraestrutura.GerenciadorSessao;
import br.com.west.interfaces.sessao.UsuarioLogado;

public class LoginControllerTest extends AbstractTest<LoginController> {

	private static final String SENHA = "senha";
	private static final String USUARIO = "usuario";

	private static AutenticacaoFacade mockAutenticacaoFacade;
	private static GerenciadorSessao mockGerenciadorSessao;

	@BeforeClass
	public static void setUp() {
		mockAutenticacaoFacade = createStrictMock(AutenticacaoFacade.class);
		mockGerenciadorSessao = createStrictMock(GerenciadorSessao.class);

		addMock(mockAutenticacaoFacade);
		addMock(mockGerenciadorSessao);
	}

	@Override
	protected LoginController createObjetoParaTestar() {
		final LoginController controller = new LoginController();

		controller.setAutenticacaoFacade(mockAutenticacaoFacade);
		controller.setGerenciadorSessao(mockGerenciadorSessao);

		controller.inicializar();

		assertNotNull(controller.getModelo());

		return controller;
	}

	@Test
	public void logarCorretoTest() throws Exception {
		final LoginController controller = createObjetoParaTestar();

		controller.getModelo().setUsuario(USUARIO);
		controller.getModelo().setSenha(SENHA);

		final Usuario usuarioRetorno = createUsuario(10L);

		final Capture<AutenticacaoVO> capture = new Capture<AutenticacaoVO>();
		final Capture<UsuarioLogado> captureUsuarioLogado = new Capture<UsuarioLogado>();

		expect(mockAutenticacaoFacade.logar(capture(capture))).andReturn(usuarioRetorno);

		mockGerenciadorSessao.setUsuarioLogado(capture(captureUsuarioLogado));

		replayAll();

		final String resultado = controller.logar();

		verifyAll();

		final AutenticacaoVO value = capture.getValue();
		final UsuarioLogado usuarioLogado = captureUsuarioLogado.getValue();

		assertEquals(value.getUsuario(), USUARIO);
		assertEquals(value.getSenha(), SENHA);

		assertEquals(usuarioLogado.getUsuario(), usuarioRetorno);
		assertEquals(resultado, ENTRAR_SISTEMA);
	}

	private Usuario createUsuario(final long id) {
		final Usuario usuarioRetorno = new Usuario();

		usuarioRetorno.setId(id);

		return usuarioRetorno;
	}

}
