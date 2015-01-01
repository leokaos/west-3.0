package br.com.west.infraestrutura;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.com.west.comum.dominio.recado.Recado;
import br.com.west.comum.dominio.recado.RecadoBuilder;
import br.com.west.comum.dominio.recado.RecadoRepository;

@Ignore
public class RecadoRepositoryTest extends AbstractRepositoryTest<RecadoRepository> {

	private Recado createRecado() {
		return RecadoBuilder.recado().descricao("TESTE").entrada(new Date()).usuario("usuario", 1L).build();
	}

	@Override
	protected String getFileDataSet() {
		return "Recados.xml";
	}

	@Override
	protected RecadoRepository createObjetoParaTestar() {
		return new RecadoRepository(entityManager);
	}

	@Test
	public void salvarRecadoValidoTest() throws Exception {
		final RecadoRepository repositorio = createObjetoParaTestar();

		repositorio.salvar(createRecado());
	}

	// @Test
	// public void bucarTodosRecadosTest() throws WestException {
	// final RecadoRepository repository = getObjeto();
	//
	// final List<Recado> listaTodosRecados = repository.buscarTodosRecados();
	//
	// assertEquals(3, listaTodosRecados.size());
	//
	// validarListaRecados(listaTodosRecados);
	// }
	//
	// @Test(expected = SemResultadoException.class)
	// public void bucarTodosRecadosListaVaziaTest() throws WestException {
	// final RecadoRepository repository = getObjeto();
	//
	// getCurrentSession().createSQLQuery("DELETE FROM tab_recados").executeUpdate();
	//
	// repository.buscarTodosRecados();
	// }
	//
	// @Test
	// public void salvarRecadoSucessoTest() {
	// final RecadoRepository repositorio = getObjeto();
	//
	// final Recado recado = createRecado();
	//
	// try {
	// repositorio.salvar(recado);
	// } catch (final WestException ex) {
	// fail(ex.getMessage());
	// }
	// }
	//
	// @Test
	// public void salvarRecadoErroTest() {
	// final RecadoRepository repositorio = getObjeto();
	//
	// final Recado recado = createRecado();
	// recado.setUsuario(null);
	//
	// try {
	// repositorio.salvar(recado);
	// fail();
	// } catch (final WestException ex) {
	// validarException(ex, ImobMensagens.MENSAGEM_RECADO_ERRO_SALVAR,
	// InfraestruturaException.class);
	// }
	// }
	//
	// @Test
	// public void buscarRecadosPorUsuarioTest() throws WestException {
	// final RecadoRepository repositorio = getObjeto();
	//
	// final Usuario usuario = (Usuario) getCurrentSession().get(Usuario.class,
	// 1L);
	//
	// final List<Recado> recados =
	// repositorio.buscarRecadosPorUsuario(usuario);
	//
	// assertEquals(2, recados.size());
	//
	// validarListaRecados(recados);
	// }
	//
	// private void validarListaRecados(final List<Recado> listaTodosRecados) {
	// Date dataAtual = null;
	//
	// for (final Recado recado : listaTodosRecados) {
	// if (isNull(dataAtual)) {
	// dataAtual = recado.getEntrada();
	// } else {
	// assertTrue(dataAtual.compareTo(recado.getEntrada()) > 0);
	// }
	// }
	// }
}
