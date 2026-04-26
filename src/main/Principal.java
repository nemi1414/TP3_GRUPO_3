package main;
import java.util.List;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;
import dao.DaoCategoria;

public class Principal {

	public static void main(String[] args) {
		 DaoProducto daoProducto = new DaoProducto();
		 DaoCategoria daoCategoria = new DaoCategoria();
		
		 		
		 //ABML Categorias:

		 Categoria categoria1 = new Categoria(1, "FFFruta");
		 Categoria categoria2 = new Categoria(2, "Limpieza");
		 Categoria categoria3 = new Categoria(3, "Alimentos");
		 Categoria categoria4 = new Categoria(4, "Bebidas");
		 Categoria categoria5 = new Categoria(5, "Mascotas");		 
	
		 //Agregamos categorias a la BD:
		 	daoCategoria.agregarCategoria(categoria1);
			daoCategoria.agregarCategoria(categoria2);
		 	daoCategoria.agregarCategoria(categoria3);
		 	daoCategoria.agregarCategoria(categoria4);
		 	daoCategoria.agregarCategoria(categoria5);
			 
		 //Eliminamos categoria 1 de la BD:
		 
		 daoCategoria.eliminarCategoria(1);
		 
		 //Cambiamos el ID de la categoria 1 y lo agregamos nuevamente: 
			categoria1.setIdCategoria(6);
			daoCategoria.agregarCategoria(categoria1);
		 
		 //Cambiamos el nombre de la categoria para corregirla y lo modificamos en la BD: 
			categoria1.setNombre("Frutas");
			daoCategoria.modificarCategoria(categoria1);
		 
		
		 //Agregamos mas categorias:
		
		 //Listado Categorias: 
		 List<Categoria> categorias = daoCategoria.listarCategorias();  	
		
		
		 System.out.println("--- Listado de Categorías ---");
		 for (Categoria c:categorias) {
			 System.out.println(c);
		 } 
		 
		 /// ABML Productos:
		 
		 //Creacion productos		 
		
		 Producto producto1 = new Producto("1", "Banana", 1250.00,50, 6 );
		 Producto producto2 = new Producto("2", "Manzana", 3350.50,100, 6 );
		 Producto producto3 = new Producto("3", "Pera", 2500.00, 30, 6 );
		 Producto producto4 = new Producto("4", "Lavandina", 1400.00, 90, 2 );
		 Producto producto5 = new Producto("5", "Detergente", 2700.00, 44, 2 );
		 Producto producto6 = new Producto("6", "Fideos Don Vicente", 1650.00, 33, 3 );
		 Producto producto7 = new Producto("7", "Coca Cola 2.5L", 3350.00, 150, 4 );
		 Producto producto8 = new Producto("8", "Sprite 2.25L", 2675.00,22, 4 );
		 Producto producto9 = new Producto("9", "Cat Chow 5kg", 7440.00, 177, 5 );
		 Producto producto10 = new Producto("10", "Royal Canin 20kg", 11250.00, 77, 5 );

		 
		 //Agregamos productos a la BD:
		 	 
		 daoProducto.agregarProducto(producto1);
		 daoProducto.agregarProducto(producto2);
		 daoProducto.agregarProducto(producto3);
		 daoProducto.agregarProducto(producto4);
		 daoProducto.agregarProducto(producto5);
		 daoProducto.agregarProducto(producto6);
		 daoProducto.agregarProducto(producto7);
		 daoProducto.agregarProducto(producto8);
		 daoProducto.agregarProducto(producto9);
		 daoProducto.agregarProducto(producto10);
		 
		 
		 //Modificamos el nombre  del producto 1 y después hacemos el UPDATE en la bd:		
		 producto1.setNombre("Banana Cavendish");
		 daoProducto.modificarProducto(producto1);
		 
		 //Eliminamos producto con Codigo = 2:
		 daoProducto.eliminarProducto("2");
		 
		 //Listamos los productos: 		 
		 
		 List<Producto> productos = daoProducto.listarProductos();
		 
		 System.out.println("--- Listado de Productos ---");
		 
		 for(Producto producto : productos) {
			 System.out.println(producto.toString());
		 }
		 
			 
		 

	}
}
