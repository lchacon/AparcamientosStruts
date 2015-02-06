package es.open4job.aytozgz.opendata.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;

import es.open4job.web.form.AparcamientoMotosForm;


public class AparcamientoMotoDAO extends GenericDAO {

	public static final Logger logger = Logger
			.getLogger(AparcamientoMotoDAO.class.getName());

	public AparcamientoMotoDAO() {
		super();
	}

	// listado de aparcamiento de motos
	public List<AparcamientoMotosForm> getLstAparcamientoMoto() throws NamingException {
		List<AparcamientoMotosForm> lsitAparcamientoMotos = new ArrayList<AparcamientoMotosForm>();

		AparcamientoMotosForm motoVO = null;
		String query = "SELECT * FROM APARCAMIENTOSMOTOS";
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			this.abrirConexion();
			// stmt = connection.createStatement();
			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery();

			while (rs.next()) {
				motoVO = new AparcamientoMotosForm(rs.getDouble("latitud"),
						rs.getDouble("longitud"), rs.getString("titulo"),
						rs.getString("icono"), rs.getString("descripcion"),
						rs.getString("last_update"), rs.getInt("plazas"),
						rs.getInt("id"));

				lsitAparcamientoMotos.add(motoVO);
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		}

		finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

		}

		return lsitAparcamientoMotos;
	}

	// Detalles de Aparcamiento de motos

	public AparcamientoMotosForm getDetailAparcamientoMoto(int motoId) throws NamingException {

		AparcamientoMotosForm aptoMoto = null;
		String query = "SELECT * FROM APARCAMIENTOSMOTOS WHERE id=?";
		ResultSet rset = null;
		PreparedStatement stmt = null;

		try {
			this.abrirConexion();
			// stmt = connection.createStatement();
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, motoId);
			rset = stmt.executeQuery();

			while (rset.next()) {
				AparcamientoMotosForm moto = new AparcamientoMotosForm(
						rset.getDouble("latitud"), rset.getDouble("longitud"),
						rset.getString("titulo"), rset.getString("icono"),
						rset.getString("descripcion"),
						rset.getString("last_update"), rset.getInt("plazas"),
						rset.getInt("id"));
				aptoMoto = moto;
			}
			stmt.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());

		} finally {

			if (rset != null) {
				try {
					rset.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

		}
		return aptoMoto;

	}
}
