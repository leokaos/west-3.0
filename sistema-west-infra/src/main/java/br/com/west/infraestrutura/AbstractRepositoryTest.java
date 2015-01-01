package br.com.west.infraestrutura;

import java.net.URL;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.dbunit.IDatabaseTester;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;

public abstract class AbstractRepositoryTest<T> extends AbstractTest<T> {

	private static String CAMINHO = "/org/west/infraestrutura/datasets/";

	protected IDatabaseTester databaseTester;
	protected final EntityManager entityManager;

	public AbstractRepositoryTest() {

		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.hsqldb.jdbcDriver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:hsqldb:mem:west_test;");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "sa");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "");

		this.entityManager = construirEntityManager();
	}

	protected IDataSet getDataSet() throws Exception {
		final URL url = this.getClass().getResource(CAMINHO + getFileDataSet());

		return new FlatXmlDataSetBuilder().build(url);
	}

	protected abstract String getFileDataSet();

	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.REFRESH;
	}

	protected DatabaseOperation getTearDownOperation() throws Exception {
		return DatabaseOperation.NONE;
	}

	private IDatabaseTester getDatabaseTester() throws Exception {
		if (databaseTester == null) {
			databaseTester = new PropertiesBasedJdbcDatabaseTester();
		}

		return databaseTester;
	}

	@Before
	public void setUp() throws Exception {
		HSQLServerUtil.getInstance().start("west_test");

		databaseTester = getDatabaseTester();

		databaseTester.setSetUpOperation(getSetUpOperation());
		databaseTester.setDataSet(getDataSet());
		databaseTester.onSetup();

	}

	@After
	public void tearDown() throws Exception {
		databaseTester = getDatabaseTester();

		databaseTester.setTearDownOperation(getTearDownOperation());
		databaseTester.setDataSet(getDataSet());
		databaseTester.onTearDown();

		databaseTester = null;

		HSQLServerUtil.getInstance().stop();
	}

	protected EntityManager construirEntityManager() {
		return Persistence.createEntityManagerFactory("west_teste").createEntityManager();
	}
}
