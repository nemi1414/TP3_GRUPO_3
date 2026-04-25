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
		 
		 ///Listado de productos
		 System.out.println("Productos:");
		 for (Producto p:productos) {
			 System.out.println(p);
		 } 
		 ///Listado de categorias
		 System.out.println("Categorias:");
		 for (Categoria c:categorias) {
			 System.out.println(c);
		 } 
		 
		 Categoria categoria = new Categoria();
		 categoria.setNombre("lechuga");
		 
		 daoCategoria.agregarCategoria(categoria);
		///Listado de categorias
		 System.out.println("Categorias:");
		 for (Categoria c:categorias) {
			 System.out.println(c);
		 } 
		 daoCategoria.eliminarCategoria(1);
		///Listado de categorias
		 System.out.println("Categorias:");
		 for (Categoria c:categorias) {
			 System.out.println(c);
		 } 
		 
		 categoria.setIdCategoria(3);
		 categoria.setNombre("fruta");
		 daoCategoria.modificarCategoria(categoria);
		 
		 
	}
}
