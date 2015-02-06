package es.open4job.aytozgz.opendata.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.CallableStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GenericDAO {
	public static final Logger logger = Logger.getLogger(GenericDAO.class
			.getName());

	protected Connection connection = null;

	public GenericDAO() {

	}

	

	public void abrirConexion() throws SQLException, ClassNotFoundException,
			NamingException {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/postgres");
			connection = ds.getConnection();

		} catch (NamingException e) {
			logger.log(Level.SEVERE,
					"NamingException : " + e.getMessage());
			throw e;
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
			throw e;
		}

	}


}
