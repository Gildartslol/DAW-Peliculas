package connector;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class connection {
	public connection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/aplicaciones_web","root","root");
			
				Statement s = conexion.createStatement();
				ResultSet rs = s.executeQuery("select * from Peliculas");
				
				while(rs.next()){
					System.out.println(rs.getInt("ID_PELICULA")+ "//" + rs.getString("NOMBRE"));
					
				}
				rs.close();
				conexion.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[]args){
		new connection();
	}
}
