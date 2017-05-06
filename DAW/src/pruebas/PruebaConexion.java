package pruebas;

import DAOS.Conexion;
import excepciones.QueryException;

public class PruebaConexion {

	public static void main(String[] args) throws QueryException {
		System.out.println(Conexion.select("Select version()"));
	}
}
