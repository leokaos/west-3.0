package br.com.west.interfaces.sessao;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.west.comum.aplicacao.recado.RecadoFacade;
import br.com.west.comum.dominio.perfil.Perfil;
import br.com.west.comum.dominio.recado.Recado;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.infraestrutura.AbstractTest;
import br.com.west.interfaces.infraestrutura.GerenciadorSessao;

import com.google.common.collect.Lists;

public class SessaoControllerTest extends AbstractTest<SessaoController> {

	private static GerenciadorSessao mockGerenciadorSessao;
	private static RecadoFacade mockRecadoFacade;

	@BeforeClass
	public static void setUp() {
		mockGerenciadorSessao = createStrictMock(GerenciadorSessao.class);
		mockRecadoFacade = createStrictMock(RecadoFacade.class);

		addMock(mockGerenciadorSessao);
		addMock(mockRecadoFacade);
	}

	@Override
	protected SessaoController createObjetoParaTestar() {
		final SessaoController sessaoController = new SessaoController();
		sessaoController.setGerenciadorSessao(mockGerenciadorSessao);
		sessaoController.setRecadoFacade(mockRecadoFacade);

		sessaoController.inicializar();

		return sessaoController;
	}

	private UsuarioLogado expectInicializar() {
		final Usuario usuario = new Usuario();

		final Set<Perfil> perfis = new HashSet<>();

		final Perfil perfil = new Perfil();
		perfil.setPaginaDashboard("pagina");
		perfis.add(perfil);

		usuario.setPerfis(perfis);

		final UsuarioLogado usuarioLogado = new UsuarioLogado(usuario);

		expect(mockGerenciadorSessao.getUsuarioLogado()).andReturn(usuarioLogado).times(2);

		return usuarioLogado;
	}

	@Test
	public void inicializarTest() throws Exception {

		final UsuarioLogado usuarioLogado = expectInicializar();

		replayAll();

		final SessaoController controller = createObjetoParaTestar();

		verifyAll();

		assertEquals(controller.getModelo().getUsuarioLogado(), usuarioLogado);
		assertEquals(controller.getModelo().getPaginaDashboard(), usuarioLogado.getPerfilPrincipal().getPaginaDashboard());
	}

	@Test
	public void buscarRecadosCorreto() throws Exception {
		final List<Recado> listaRecados = Lists.newArrayList();
		listaRecados.add(new Recado());

		expectInicializar();

		expect(mockRecadoFacade.buscarRecadosPorUsuario(new Usuario())).andReturn(listaRecados);

		replayAll();

		final SessaoController controller = createObjetoParaTestar();

		controller.buscarRecados();

		verifyAll();

		assertEquals(controller.getModelo().getRecados(), listaRecados);
	}

}
