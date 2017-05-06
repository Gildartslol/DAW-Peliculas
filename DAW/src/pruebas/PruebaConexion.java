package pruebas;

import dao.Conexion;
import dao.Qry;
import excepciones.QueryException;

public class PruebaConexion {

	public static void main(String[] args) throws QueryException {
		
		
		
		Qry qry  = new Qry("select &1 ");
		qry.setParam("version()");
		
		
		System.out.println(Conexion.select(qry.toString()));
	}
}
