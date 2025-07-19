/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClaseModeloPojos;

/**
 *
 * @author MichBalcazar
 */
import ClaseModeloPojos.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {
    public static void main(String[] args) {
        try {
            Connection conexion = ConexionDB.getConexion(); // Llamamos a nuestro método
            if (conexion != null) {
                System.out.println("Conexion exitosa a la base de datos");
                conexion.close(); // Cerramos la conexión cuando terminamos
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}