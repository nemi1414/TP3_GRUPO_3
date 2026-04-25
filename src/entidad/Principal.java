package entidad;
import java.util.List;
import dao.DaoProducto;
import dao.DaoCategoria;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DaoProducto daoProducto = new DaoProducto();
		 DaoCategoria daoCategoria = new DaoCategoria();
		 List<Producto> productos = daoProducto.listarProductos();
		 List<Categoria> categorias = daoCategoria.listarCategorias();
		 
		///Listado de categorias
		 System.out.println("Categorias:");
		 for (Categoria c:categorias) {
			 System.out.println(c);
		 } 
		 ///Listado de productos
		 System.out.println("Productos:");
		 for (Producto p:productos) {
			 System.out.println(p);
		 } 
	}
}
