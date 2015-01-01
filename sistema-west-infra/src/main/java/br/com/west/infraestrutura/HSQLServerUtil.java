package br.com.west.infraestrutura;

import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerConfiguration;

public class HSQLServerUtil {

	private static final HSQLServerUtil INSTANCE = new HSQLServerUtil();

	private Server hsqlServer;

	private HSQLServerUtil() {
		super();
	}

	public static HSQLServerUtil getInstance() {
		return INSTANCE;
	}

	private void doStart(final HsqlProperties props) throws Exception {

		ServerConfiguration.translateDefaultDatabaseProperty(props);

		hsqlServer = new Server();

		hsqlServer.setRestartOnShutdown(false);
		hsqlServer.setNoSystemExit(true);
		hsqlServer.setProperties(props);
		hsqlServer.setSilent(true);

		hsqlServer.start();
	}

	public void start(final String dbName, final int port) throws Exception {
		final HsqlProperties props = new HsqlProperties();

		props.setProperty("server.port", port);
		props.setProperty("server.database.0", dbName);
		props.setProperty("server.dbname.0", dbName);

		doStart(props);
	}

	public void start(final String dbName) throws Exception {
		final HsqlProperties props = new HsqlProperties();

		props.setProperty("server.database.0", dbName);
		props.setProperty("server.dbname.0", dbName);

		doStart(props);
	}

	public void stop() {
		hsqlServer.shutdown();
		hsqlServer.stop();
	}
}
