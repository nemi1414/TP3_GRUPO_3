package dao;
 
import entidad.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	 public int eliminarCategoria(int idCategoria) {
	        String query = "DELETE FROM Categorias WHERE IdCategoria = ?";
	        Conexion conexion = new Conexion();
	        Connection cn = null;
	        try {
	            cn = conexion.getConnection();
	            PreparedStatement ps = cn.prepareStatement(query);
	            ps.setInt(1, idCategoria);
	            return ps.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }
	 
	    public List<Categoria> listarCategorias() {
	        List<Categoria> lista = new ArrayList<>();
	        String query = "SELECT IdCategoria, Nombre FROM Categorias";
	        Conexion conexion = new Conexion();
	        Connection cn = null;
	        try {
	            cn = conexion.getConnection();
	            Statement st = cn.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            while (rs.next()) {
	                Categoria c = new Categoria();
	                c.setIdCategoria(rs.getInt("IdCategoria"));
	                c.setNombre(rs.getString("Nombre"));
	                lista.add(c);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return lista;
	    }
}
