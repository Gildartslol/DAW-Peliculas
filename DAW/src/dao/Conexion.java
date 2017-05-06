package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import excepciones.QueryException;

public class Conexion {

	private static Connection conn;
	private static final String URL = "jdbc:mysql://localhost:3306/aplicaciones_web?" + "user=root&password=1212";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL);
		} catch (SQLException | ClassNotFoundException e) {
			// handle any errors
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + ((SQLException) e).getSQLState());
			System.out.println("VendorError: " + ((SQLException) e).getErrorCode());
		}
	}

	public static Connection conexion() throws SQLException {
		if (conn.isClosed()) {
			conn = DriverManager.getConnection(URL);
		}
		return conn;
	}

	/**
	 * Devuelve todas las filas
	 * 
	 * @param query
	 * @return
	 * @throws QueryException
	 */
	public static String select(String query) throws QueryException {
		Statement stmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			stmt = Conexion.conexion().createStatement();
			rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++ ) {
				sb.append(rs.getString(i) + " ");
				}
				
				sb.append("\n");
			}

		} catch (SQLException ex) {
			throw new QueryException("No ha sido posible hacer la busqueda", ex);
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				stmt = null;
			}
		}

		return sb.toString();
	}
	/**
	 * Esta select, al no tener un contenedor de datos, la usaremos para cuando esperamos un resultado
	 * @param query
	 * @return
	 * @throws QueryException
	 */
	public static String selectUnique(String query) throws QueryException {
		Statement stmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			stmt = Conexion.conexion().createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				sb.append(rs.getString(1));
				}
				
		} catch (SQLException ex) {
			throw new QueryException("No ha sido posible hacer la busqueda", ex);
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				stmt = null;
			}
		}

		return sb.toString();
	}

}
