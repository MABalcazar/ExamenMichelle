package ServicioControlador;

import ClaseModeloPojos.ConexionDB;
import java.sql.Connection;
import java.util.Scanner;

public class MainAgregarProducto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Connection conn = ConexionDB.getConexion();
            ProductoDao dao = new ProductoDao(conn);

            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.print("Descripcion del producto: ");
            String descripcion = scanner.nextLine();

            boolean exito = dao.agregarProducto(nombre, descripcion);

            if (exito) {
                System.out.println("Producto agregado correctamente.");
            } else {
                System.out.println("No se pudo agregar el producto.");
            }

        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }
}
