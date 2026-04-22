package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "admin";
	private String pass = "admin";
	private String dbName = "bdInventario";
	
	public Connection getConnection() {
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			System.out.println("conectado");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cn;
	}
}