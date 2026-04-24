package dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import entidad.Producto;

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
	
	
}
