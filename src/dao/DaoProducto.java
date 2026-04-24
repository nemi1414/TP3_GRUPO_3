package dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import entidad.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoProducto {

	public void agregarProducto(Producto producto) {		

		Conexion conexion = new Conexion();
		Connection cn = null;

		try {
			cn = conexion.getConnection();
			CallableStatement cst = cn.prepareCall("CALL sp_AgregarProducto(?,?,?,?,?)");
			
			cst.setString(1, producto.getCodigo());
			cst.setString(2, producto.getNombre());
			cst.setDouble(3, producto.getPrecio());
			cst.setInt(4, producto.getStock());
			cst.setInt(5, producto.getIdCategoria());
			cst.execute(); 
							
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	 public int modificarProducto(Producto producto) {
	        String query = "UPDATE Productos SET Nombre = ?, Precio = ?, Stock = ?, IdCategoria = ? WHERE Codigo = ?";

	        Conexion conexion = new Conexion();
	        Connection cn = null;

	        try {
	            cn = conexion.getConnection();
	            PreparedStatement ps = cn.prepareStatement(query);

	            ps.setString(1, producto.getNombre());
	            ps.setDouble(2, producto.getPrecio());
	            ps.setInt(3, producto.getStock());
	            ps.setInt(4, producto.getIdCategoria());
	            ps.setString(5, producto.getCodigo());

	            return ps.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }
	 
	 public int eliminarProducto(String codigo) {
	        String query = "DELETE FROM Productos WHERE codigo = ?";

	        Conexion conexion = new Conexion();
	        Connection cn = null;

	        try {
	            cn = conexion.getConnection();
	            PreparedStatement ps = cn.prepareStatement(query);

	            ps.setString(1, codigo);

	            return ps.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }
	 
	 public List<Producto> listarProductos() {
	        List<Producto> lista = new ArrayList<>();

	        String query = "SELECT codigo, nombre, precio, stock, idCategoria FROM Productos";

	        Conexion conexion = new Conexion();
	        Connection cn = null;

	        try {
	            cn = conexion.getConnection();
	            Statement st = cn.createStatement();
	            ResultSet rs = st.executeQuery(query);

	            while (rs.next()) {
	                Producto p = new Producto();

	                p.setCodigo(rs.getString("codigo"));
	                p.setNombre(rs.getString("nombre"));
	                p.setPrecio(rs.getDouble("precio"));
	                p.setStock(rs.getInt("stock"));
	                p.setIdCategoria(rs.getInt("idCategoria"));

	                lista.add(p);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return lista;
	    }
	
}
