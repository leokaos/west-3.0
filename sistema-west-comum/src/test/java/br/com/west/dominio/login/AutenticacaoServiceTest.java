package br.com.west.dominio.login;

import static br.com.west.comum.aplicacao.ComumMesssages.USUARIO_BLOQUEADO;
import static br.com.west.comum.aplicacao.ComumMesssages.USUARIO_INEXISTENTE;
import static br.com.west.comum.aplicacao.ComumMesssages.USUARIO_SEM_PERFIL;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.west.comum.aplicacao.usuario.UsuarioFacade;
import br.com.west.comum.dominio.login.AutenticacaoService;
import br.com.west.comum.dominio.login.AutenticacaoVO;
import br.com.west.comum.dominio.perfil.Perfil;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.DominioException;
import br.com.west.context.exception.SemResultadoException;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.AbstractTest;
import br.com.west.util.CriptoUtil;

public class AutenticacaoServiceTest extends AbstractTest<AutenticacaoService> {

	private static UsuarioFacade mockUsuarioFacade;

	@BeforeClass
	public static void setUp() {
		mockUsuarioFacade = createStrictMock(UsuarioFacade.class);

		addMock(mockUsuarioFacade);
	}

	@Override
	protected AutenticacaoService createObjetoParaTestar() {
		return new AutenticacaoService(mockUsuarioFacade);
	}

	@Test
	public void logarCorretoTest() throws Exception {
		final AutenticacaoService service = createObjetoParaTestar();

		final Usuario usuario = new Usuario();
		final Set<Perfil> perfis = new HashSet<Perfil>();
		perfis.add(new Perfil());

		usuario.setPerfis(perfis);

		expect(mockUsuarioFacade.buscarUsuarioPorNomeSenha("usuario", CriptoUtil.hash("senha"))).andReturn(usuario);

		replayAll();

		try {
			service.logar(new AutenticacaoVO("usuario", "senha"));
		} catch (final WestException e) {
			fail();
		}

		verifyAll();
	}

	@Test
	public void logarUsuarioSemPerfilTest() throws Exception {
		final AutenticacaoService service = createObjetoParaTestar();

		final Usuario usuario = new Usuario();
		final Set<Perfil> perfis = new HashSet<Perfil>();
		perfis.add(new Perfil());

		expect(mockUsuarioFacade.buscarUsuarioPorNomeSenha("usuario", CriptoUtil.hash("senha"))).andReturn(usuario);

		replayAll();

		try {
			service.logar(new AutenticacaoVO("usuario", "senha"));
			fail();
		} catch (final WestException e) {
			validarException(e, USUARIO_SEM_PERFIL, DominioException.class);
		}

		verifyAll();
	}

	@Test
	public void logarUsuarioInexistenteTest() throws Exception {
		final AutenticacaoService service = createObjetoParaTestar();

		expect(mockUsuarioFacade.buscarUsuarioPorNomeSenha("usuario", CriptoUtil.hash("senha"))).andThrow(new SemResultadoException());

		replayAll();

		try {
			service.logar(new AutenticacaoVO("usuario", "senha"));
			fail();
		} catch (final WestException e) {
			validarException(e, USUARIO_INEXISTENTE, DominioException.class);
		}

		verifyAll();
	}

	@Test
	public void logarUsuarioBloqueadoTest() throws Exception {
		final AutenticacaoService service = createObjetoParaTestar();

		final Usuario usuario = new Usuario();
		usuario.setBloqueado(true);

		expect(mockUsuarioFacade.buscarUsuarioPorNomeSenha("usuario", CriptoUtil.hash("senha"))).andReturn(usuario);

		replayAll();

		try {
			service.logar(new AutenticacaoVO("usuario", "senha"));
			fail();
		} catch (final WestException e) {
			validarException(e, USUARIO_BLOQUEADO, DominioException.class);
		}

		verifyAll();
	}

}
