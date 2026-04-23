package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import entidad.Categoria;

public class DaoCategoria {

	public int agregarCategoria(Categoria categoria) {
		String query = "INSERT INTO Categorias(Nombre) VALUES (?)";

		Conexion conexion = new Conexion();
		Connection cn = null;

		try {
			cn = conexion.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1, categoria.getNombre());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int modificarCategoria(Categoria categoria) {
		String query = "UPDATE categorias SET Nombre = ? WHERE IdCategoria = ?";
		Conexion conexion = new Conexion();
		Connection cn = null;

		try {
			cn = conexion.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1, categoria.getNombre());
			ps.setInt(2, categoria.getIdCategoria());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
