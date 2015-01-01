package br.com.west.comum.dominio.usuario;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.startup.query.QueryBuilder;
import br.com.west.infraestrutura.AbstractTest;

public class UsuarioFiltroTest extends AbstractTest<UsuarioFiltro> {

	private static EntityManager mockEntityManager;
	private static Query mockQuery;

	@BeforeClass
	public static void setUp() {
		mockEntityManager = createStrictMock(EntityManager.class);
		mockQuery = createStrictMock(Query.class);

		addMock(mockEntityManager);
		addMock(mockQuery);
	}

	@Override
	protected UsuarioFiltro createObjetoParaTestar() {
		return new UsuarioFiltro();
	}

	@Test
	public void construirQuerySemParametrosTest() throws Exception {
		final UsuarioFiltro filtro = createObjetoParaTestar();

		expect(mockEntityManager.createQuery("SELECT usuario FROM Usuario usuario")).andReturn(mockQuery);

		replayAll();

		final QueryBuilder queryBuilder = QueryBuilder.select(Usuario.class);

		filtro.doQuery(queryBuilder);

		queryBuilder.build(mockEntityManager);

		verifyAll();
	}

	@Test
	public void construirQueryComApenasUmParametroTest() throws Exception {
		final UsuarioFiltro filtro = createObjetoParaTestar();

		filtro.setNomeUsuario("nomeUsuario");

		expect(mockEntityManager.createQuery("SELECT usuario FROM Usuario usuario")).andReturn(mockQuery);

		replayAll();

		final QueryBuilder queryBuilder = QueryBuilder.select(Usuario.class);

		filtro.doQuery(queryBuilder);

		queryBuilder.build(mockEntityManager);

		verifyAll();
	}

	@Test
	public void construirQueryComParametrosTest() throws Exception {
		final UsuarioFiltro filtro = createObjetoParaTestar();

		filtro.setNomeUsuario("nomeUsuario");
		filtro.setSenha("senha");

		final String hqlString = "SELECT usuario FROM Usuario usuario WHERE (usuario.nome = :p1 AND usuario.senha = :p2)";

		expect(mockEntityManager.createQuery(hqlString)).andReturn(mockQuery);
		expect(mockQuery.setParameter("p1", "nomeUsuario")).andReturn(mockQuery);
		expect(mockQuery.setParameter("p2", "senha")).andReturn(mockQuery);

		replayAll();

		final QueryBuilder queryBuilder = QueryBuilder.select(Usuario.class);

		filtro.doQuery(queryBuilder);

		queryBuilder.build(mockEntityManager);

		verifyAll();

	}

	@Test
	public void equalsAndHashCodeTest() throws Exception {
		final UsuarioFiltro filtro1 = createObjetoParaTestar();
		final UsuarioFiltro filtro2 = createObjetoParaTestar();

		assertEquals(filtro1, filtro2);
		assertEquals(filtro1.hashCode(), filtro2.hashCode());

		filtro1.setNomeUsuario("nomeUsuario");
		filtro2.setNomeUsuario("nomeUsuario");

		filtro1.setSenha("senha");
		filtro2.setSenha("senha");

		assertEquals(filtro1, filtro2);
		assertEquals(filtro1.hashCode(), filtro2.hashCode());
	}

}
