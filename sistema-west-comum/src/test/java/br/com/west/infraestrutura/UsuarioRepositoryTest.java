package br.com.west.infraestrutura;

import br.com.west.comum.dominio.usuario.UsuarioRepository;

public class UsuarioRepositoryTest extends AbstractRepositoryTest<UsuarioRepository> {

	@Override
	protected String getFileDataSet() {
		return "Usuarios.xml";
	}

	@Override
	protected UsuarioRepository createObjetoParaTestar() {
		return new UsuarioRepository(entityManager);
	}

	// @Test
	// public void buscarUsuarioPorNivelRecepcaoCorretorTest() throws
	// WestException {
	// final UsuarioRepository repositorio = createObjetoParaTestar();
	//
	// final List<Usuario> listaUsuariosRecepcao =
	// repositorio.buscarUsuarioPorNivel(TipoUsuario.RECEPCAO);
	// assertEquals(listaUsuariosRecepcao.size(), 1);
	//
	// final List<Usuario> listaUsuariosCorretor =
	// repositorio.buscarUsuarioPorNivel(TipoUsuario.CORRETOR);
	// assertEquals(listaUsuariosCorretor.size(), 1);
	// }
	//
	// @Test
	// public void buscarUsuarioPorNivelErroSemResultadoTest() throws
	// WestException {
	// final UsuarioRepository repositorio = createObjetoParaTestar();
	//
	// try {
	// repositorio.buscarUsuarioPorNivel(TipoUsuario.CORRETOR);
	// } catch (final WestException ex) {
	// validarException(ex, ImobMensagens.MENSAGEM_COMUM_SEM_RESULTADO,
	// SemResultadoException.class);
	// }
	// }
	//
	// @Test
	// public void buscarUsuariosLogadosPorNivelRecepcaoTest() throws
	// WestException {
	// final UsuarioRepository repositorio = createObjetoParaTestar();
	//
	// final Ponto ponto = PontoDAO.load(836l);
	// ponto.setDataPonto(new Date());
	//
	// PontoDAO.save(ponto);
	//
	// final List<Usuario> listaUsuariosRecepcao =
	// repositorio.buscarUsuariosLogadosPorNivel(TipoUsuario.RECEPCAO);
	// assertEquals(listaUsuariosRecepcao.size(), 1);
	// }
}
